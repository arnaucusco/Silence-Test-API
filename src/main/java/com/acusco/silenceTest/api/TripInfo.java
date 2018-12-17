package com.acusco.silenceTest.api;

public class TripInfo {
	
	private Long timeElapsed;
	private Double distanceTraveled; //meters
	
	public long getTimeElapsed() {
		return timeElapsed;
	}
	public void setTimeElapsed(Long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
	public Double getDistanceTraveled() {
		return distanceTraveled;
	}
	public void setDistanceTraveled(Double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

}
