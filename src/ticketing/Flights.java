package ticketing;



public class Flights {
	
	private int FlightID;
	private String departure;
	private String destination;
	private int seatsAvailable;
	
	public Flights(int FlightID, String departure, String destination, int seatsAvailable) {

		this.FlightID = FlightID;
		this.departure = departure;
		this.destination = destination;
		this.seatsAvailable = seatsAvailable;

	}
	
	public int getFlightID() {
		return FlightID;
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
