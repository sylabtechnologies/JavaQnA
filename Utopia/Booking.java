public class Booking {
	int id;
	int flightId;
	int isActive;
	String stripeId;
	int bookerId;

	public Booking(int id, int flightId, int isActive, String stripeId, int bookerId) {
		this.id = id;
		this.flightId = flightId;
		this.isActive = isActive;
		this.stripeId = stripeId;
		this.bookerId = bookerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
