package com.acusco.silenceTest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.acusco.silenceTest.api.APIController;
import com.acusco.silenceTest.api.APIService;
import com.acusco.silenceTest.api.initModel;

@RunWith(SpringRunner.class)
@WebMvcTest(APIController.class)
@Import(initModel.class)
public class APIControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private APIService apiService;

	@Autowired
	@Qualifier("barcelonaGPSCooordinate")
	private GPSCoordinate barcelonaGPSCooordinate;
	
	@Autowired
	@Qualifier("vilafrancaGPSCooordinate")
	private GPSCoordinate vilafrancaGPSCooordinate;

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/turnOn").param("scooterId", "1").param("turnOn", "true"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/move").param("scooterId", "1")
						.param("latitude", vilafrancaGPSCooordinate.getLatitude().toString())
						.param("longitude", vilafrancaGPSCooordinate.getLongitude().toString()))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/turnOn").param("scooterId", "1").param("turnOn", "false"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/getTrips").param("scooterId", "1"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
}
