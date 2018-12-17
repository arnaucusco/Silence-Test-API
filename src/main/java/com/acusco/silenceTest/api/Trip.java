package com.acusco.silenceTest.api;
import java.time.Duration;
import java.time.LocalDateTime;

public class Trip {

	private LocalDateTime start;
	private GPSCoordinate gpsCoordinateStart;
	private LocalDateTime end;
	private GPSCoordinate gpsCoordinateStop;

	public void setStart(GPSCoordinate gpsCoordinate, LocalDateTime start) {
		this.gpsCoordinateStart = gpsCoordinate;
		this.start = start;
	}

	public void setStop(GPSCoordinate gpsCoordinate, LocalDateTime start) {
		this.gpsCoordinateStop = gpsCoordinate;
		this.end = start;
	}

	public TripInfo getTripInfo() {
		TripInfo tripInfo = new TripInfo();
		if (gpsCoordinateStart != null && gpsCoordinateStop != null) {
			tripInfo.setDistanceTraveled(GPSCoordinate.distance(gpsCoordinateStart, gpsCoordinateStop));
		}
		if (start != null && end != null) {
			Duration duration = Duration.between(end, start);
			tripInfo.setTimeElapsed(Math.abs(duration.toMinutes()));
		}
		return tripInfo;
	}

}
