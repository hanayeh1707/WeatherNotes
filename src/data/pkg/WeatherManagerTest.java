package data.pkg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWeather() {
	String[] weatherStatus= WeatherManager.getWeather(); 
	assertTrue(weatherStatus.length==2);
	}

}
