package ticketing;



public class Flights {
	
	private int flightID;
	private String departure;
	private String destination;
	private int seatsAvailable;
	
	public Flights(int flightID, String departure, String destination, int seatsAvailable) {

		this.flightID = flightID;
		this.departure = departure;
		this.destination = destination;
		this.seatsAvailable = seatsAvailable;

	}
	
	public int getFlightID() {
		return flightID;
	}
	
	public String getDeparture() {
		return departure;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	
	
}
