package com.utopia.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.utopia.booking.model.Booking;
import com.utopia.booking.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;

	@Value("${flight.port}")
	String flightPort;

	@Value("${flight.decrement.url}")
	String decrement;

	@Value("${flight.increment.url}")
	String increment;

	private static final String host = "127.0.0.1:";

	@RequestMapping(path = "booking/{bookingId}", method = RequestMethod.GET)
	public Booking get(@PathVariable int bookingId)
	{
		return service.getBooking(bookingId);
	}

	@RequestMapping(path = "booking/{flightId}/{bookerId}", method = RequestMethod.POST)
	public Booking create(@PathVariable int flightId, @PathVariable int bookerId)
	{
		RestTemplate req = new RestTemplate();
		ResponseEntity<String> resp =
			req.getForEntity(host + flightPort + "/" + decrement + "/" + flightId, String.class);

		if (resp.getStatusCode() != HttpStatus.OK)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "flight error");

		if (!resp.getBody().equals("OK"))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unavailable");

		return service.create(flightId, bookerId);
	}

	// deactivate booking and increase flight capacity
	@RequestMapping(path = "booking/pruned/{bookingId}", method = RequestMethod.PUT)
	public void rollback(@PathVariable int bookingId)
	{
		Booking book = service.getBooking(bookingId);

		if (book == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cant find");

		book.setIsActive(0);
		service.update(book);

		RestTemplate req = new RestTemplate();
		ResponseEntity<String> resp =
			req.getForEntity(host + flightPort + "/" + increment + "/" + book.getFlightId(), String.class);

		if (resp.getStatusCode() != HttpStatus.OK)
			throw new ResponseStatusException(HttpStatus.FAILED_DEPENDENCY, "flight error");

		if (!resp.getBody().equals("OK"))
			throw new ResponseStatusException(HttpStatus.FAILED_DEPENDENCY, "flight error");
	}

	@RequestMapping(path = "booking/inactive/{bookingId}", method = RequestMethod.PUT)
	public void deactivate(@PathVariable int bookingId)
	{
		Booking book = service.getBooking(bookingId);

		if (book == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cant find");

		book.setIsActive(0);
		service.update(book);
	}

}

