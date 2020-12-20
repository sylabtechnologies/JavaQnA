public class Payment {
	int id;
	int bookerId;
	int flightId;

	public Payment(int id, int bookerId, int flightId)
	{
		this.id = id;
		this.bookerId = bookerId;
		this.flightId = flightId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookerId() {
		return bookerId;
	}

	public void setBookerId(int bookerId) {
		this.bookerId = bookerId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

}
