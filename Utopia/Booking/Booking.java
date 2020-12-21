package com.utopia.booking.model;

import javax.persistence.*;

/*
 * -- insert into tbl_booking (bookingId, flightId, isActive, stripeId, bookerId) values(1,2,1,"***",5)
 */

@Entity
@Table (name = "tbl_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(name="flightId")
    private int flightId;

    @Column(name="isActive")
    private int isActive;

    @Column(name="stripeId")
    private String stripeId;

    @Column(name="bookerId")
    private int bookerId;

	public Booking() {};

	public Booking(int flightId, int isActive, String stripeId, int bookerId)
	{
		this.flightId = flightId;
		this.isActive = isActive;
		this.stripeId = stripeId;
		this.bookerId = bookerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getStripeId() {
		return stripeId;
	}

	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	public int getBookerId() {
		return bookerId;
	}

	public void setBookerId(int bookerId) {
		this.bookerId = bookerId;
	}

}
