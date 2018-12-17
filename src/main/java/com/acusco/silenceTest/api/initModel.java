package com.acusco.silenceTest.api;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initModel {

	@Bean
	public GPSCoordinate barcelonaGPSCooordinate() {
		return new GPSCoordinate(41.390205, 2.154007);
	}
	
	@Bean
	public GPSCoordinate vilafrancaGPSCooordinate() {
		return new GPSCoordinate(41.3461265, 1.6979398);
	}
	
	@Bean
	public Scooter scooter1() {
		return new Scooter(1, barcelonaGPSCooordinate());
	}
	

	@Bean
	public Scooter scooter2() {
		return new Scooter(1, vilafrancaGPSCooordinate());
	}
	
	@Bean
	public Map<Integer,Scooter> scooters() {
		Scooter scooter1 = scooter1();
		Scooter scooter2 = scooter2();
		Map<Integer,Scooter> scooters = new HashMap<>();
		scooters.put(scooter1.getId(),scooter1());
		scooters.put(scooter2.getId(),scooter2());
		return scooters;
	}
}
