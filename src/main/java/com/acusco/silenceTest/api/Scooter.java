package com.acusco.silenceTest.api;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scooter {

	private Integer id;
	private GPSCoordinate gpsCoordinate;
	private Boolean turnOn = false;
	private List<Trip> trips = new ArrayList<>();

	public Scooter(Integer id, GPSCoordinate gpsCoordinate) {
		this.id = id;
		this.gpsCoordinate = gpsCoordinate;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setGpsCoordinate(GPSCoordinate gpsCoordinate) {
		this.gpsCoordinate = gpsCoordinate;
	}
	
	public void turnOn(Boolean turnOn) {
		if (turnOn && (!this.turnOn)) {
			this.turnOn = turnOn;
			startTrip();
		} else if ((!turnOn) && this.turnOn) {
			this.turnOn = turnOn;
			stopTrip();
		}
	}

	private void startTrip() {
		Trip trip = new Trip();
		trip.setStart(gpsCoordinate, LocalDateTime.now());
		trips.add(trip);
	}

	private void stopTrip() {
		Trip trip = trips.get(trips.size()-1);
		trip.setStop(gpsCoordinate, LocalDateTime.now());
	}

	public List<TripInfo> getTripsInfo() {
		List<TripInfo> tripInfos = new ArrayList<>();
		for(Trip trip: trips) {
			tripInfos.add(trip.getTripInfo());
		}
		return tripInfos;
	}

}
