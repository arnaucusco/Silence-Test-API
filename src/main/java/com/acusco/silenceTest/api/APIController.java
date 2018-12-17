package com.acusco.silenceTest.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	
	@Autowired
	APIService apiService;

	@RequestMapping(value = "/turnOn", method = { RequestMethod.GET})
	public void turnOn(@RequestParam("scooterId") Integer scooterId, @RequestParam("turnOn") Boolean turnOn) {
		apiService.turnOn(scooterId, turnOn);
	}
	
	@RequestMapping(value = "/move", method = { RequestMethod.GET})
	public void move(@RequestParam("scooterId") Integer scooterId, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
		GPSCoordinate gpsCoordinate = new GPSCoordinate(latitude, longitude);
		gpsCoordinate.setLatitude(latitude);
		gpsCoordinate.setLongitude(longitude);
		apiService.move(scooterId, gpsCoordinate);
	}
	
	@RequestMapping(value = "/getTrips", method = { RequestMethod.GET}, produces = "application/json")
	public @ResponseBody List<TripInfo> getTrips(@RequestParam("scooterId") Integer scooterId) {
		return apiService.getTrips(scooterId);
	}

}
