package com.utopia.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utopia.booking.model.Booking;
import com.utopia.booking.service.dao.BookingDAO;
import java.util.List;
import java.util.Optional;

@Component
public class BookingService {

	@Autowired
	BookingDAO dao;

	public Booking get(int bookingId)
	{
		Optional<Booking> book = dao.findById((long) bookingId);

		if (book.isPresent())
			return book.get();
		else
			return null;
	}

	public Booking create(int flightId, int bookerId)
	{
		Booking book = new Booking(flightId, 1, "***", bookerId);
		dao.save(book);
		return book;
	}

	public void update(Booking book)
	{
		dao.save(book);
	}

}
