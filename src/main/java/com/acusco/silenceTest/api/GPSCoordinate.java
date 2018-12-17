package com.acusco.silenceTest.api;

public class GPSCoordinate {

	private Double latitude;
	private Double longitude;

	public GPSCoordinate(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public static Double distance(GPSCoordinate gpsCoordinate1, GPSCoordinate gpsCoordinate2) {
		Integer earthRadiusKm = 6371;

		Double latitudeDiff = degreesToRadians(gpsCoordinate2.getLatitude() - gpsCoordinate1.getLatitude());
		Double longitudeDiff = degreesToRadians(gpsCoordinate2.getLongitude() - gpsCoordinate1.getLongitude());

		Double a = Math.sin(latitudeDiff / 2) * Math.sin(latitudeDiff / 2) 
				+ Math.sin(longitudeDiff / 2) * Math.sin(longitudeDiff / 2) 
				* Math.cos(degreesToRadians(gpsCoordinate1.getLatitude())) 
				* Math.cos(degreesToRadians(gpsCoordinate2.getLatitude()));
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return earthRadiusKm * c * 1000;
	}

	private static Double degreesToRadians(Double degrees) {
		return degrees * Math.PI / 180;
	}

}
