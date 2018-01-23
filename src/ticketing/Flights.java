package ticketing;

import java.util.Date;

public class Flights {
	
	private String FlightID;
	private String departure;
	private String destination;
	private Date departureDate;
	private int time;
	private int seatsAvailable;
	
	public Flights(String FlightID, String departure, String destination, Date departureDate, int time, int seatsAvailable) {

		this.FlightID = FlightID;
		this.departure = departure;
		this.destination = destination;
		this.departureDate = departureDate;
		this.time = time;
		this.seatsAvailable = seatsAvailable;

	}
	
	public String getFlightID() {
		return FlightID;
	}
	
	public String getDeparture() {
		return departure;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public Date getDepartureDate() {
		return departureDate;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	
	public int getTime() {
		return time;
	}
}
