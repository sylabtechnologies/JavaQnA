package com.utopia.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.utopia.booking.model.Booking;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long>
{

}
