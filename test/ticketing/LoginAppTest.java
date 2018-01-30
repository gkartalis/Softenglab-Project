package ticketing;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import org.junit.Test;


public class LoginAppTest {

	LoginApp tester = new LoginApp();
	
  
	@Test
	public void testLoginAdmin() {
		tester.db.checkLogin("admin", "password");
		
	}
	
	@Test
	public void testLoginUser() {
		tester.db.checkLogin("user", "password");
	}
	@Test
	public void testFalse() {
		tester.db.checkLogin("admin", "passwosssssrd");
	}
	
	@Test
	public void testFlights() {
		Flights flight = new Flights(215,"Test","Lol",33);
		assertEquals(215,flight.getFlightID());
		assertEquals("Test",flight.getDeparture());
		assertEquals("Lol",flight.getDestination());
		assertEquals(33,flight.getSeatsAvailable());
	}
	
	@Test
	public void testIsEmptySqlTable() {
		assertNotNull(tester.db.fetchLatestAnnouncement());
	}
	
	@Test
	public void testShowStatistics() {
		assertNotNull(tester.db.showStatistics("2018-04-01"));
	}
	
	@Test
	public void testFlightList() {
		ArrayList<Flights> list = new ArrayList<Flights>();
		Exception eOutOfBounds = null;
		try {
			Object o = list.get(1);
		}catch(IndexOutOfBoundsException e) {
			eOutOfBounds = e;
		}
		assertNotNull("No expected Exception", eOutOfBounds);
	}
	
	@Test
	public void testFlightsList() {
		ArrayList<Flights> list = new ArrayList<Flights>();
		assertNotNull("",tester.db.flightList("test"));
		
	}
	
	@Test
	public void testAddStats() {
		tester.db.addStatistics(1, "2018-04-01");
		
	}

}
