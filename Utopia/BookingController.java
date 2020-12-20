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

import com.smoothstack.dec2020.model.Booking;
import com.smoothstack.dec2020.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Value("${flightcapacity.url}")
	String flightUrl;

	@RequestMapping(path = "booking/{flightId}/{bookerId}", method = RequestMethod.POST)
	public Booking createBooking(@PathVariable int flightId, @PathVariable int bookerId)
	{
		RestTemplate req = new RestTemplate();

		ResponseEntity<String> response =
			req.getForEntity(flightUrl + flightId, String.class);

		if (response.getStatusCode() != HttpStatus.OK)
			throw new ResponseStatusException(response.getStatusCode(), "bad request");

		if (response.getBody().equals("{}"))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not available");

		return bookingService.createBooking(flightId, bookerId);
	}

	@RequestMapping(path = "booking/inactive/{bookingId}", method = RequestMethod.PUT)
	public void deactivateBooking(@PathVariable int bookingId)
	{
		if (!bookingService.deactivateBooking(bookingId))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bad request");
	}

}
