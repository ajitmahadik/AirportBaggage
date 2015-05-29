package com.example.barclays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Departure {
	private String flightId;
	private String flightGate;
	private String destination;
	private Date flightTime;

	List<Bag> bags = new ArrayList<Bag>();

	public Departure(String flightId, String flightGate, String destination, String date) {
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

		Calendar cal = Calendar.getInstance();
		Calendar today = Calendar.getInstance();

		try {
			Date parse = sdf.parse(date);
			cal.setTime(parse);
			today.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
			today.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
			today.set(Calendar.SECOND, 00);

			this.flightTime = today.getTime();
		} catch (ParseException e) {
		}
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

	public void addBags(Bag bag) {
		this.bags.add(bag);
	}
}
