package com.acusco.silenceTest.api;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIService {

	@Autowired
	public Map<Integer, Scooter> scooters;
	
	public void turnOn(Integer scooterId, Boolean turnOn) {
		scooters.get(scooterId).turnOn(turnOn);
	}

	public void move(Integer scooterId, GPSCoordinate gpsCoordinate) {
		scooters.get(scooterId).setGpsCoordinate(gpsCoordinate);
	}

	public List<TripInfo> getTrips(Integer scooterId) {
		return scooters.get(scooterId).getTripsInfo();
	}
}
