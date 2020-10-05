package data.pkg;
import com.teknikindustries.yahooweather.*;



public class WeatherManager {
/**
 * 
 * @return String Array{Temperature, Humidity, Wind Speed}
 */
	public static String [] getWeather()
	{
		WeatherDoc doc = new WeatherDoc("1521894","c");	
		
		WeatherDisplay disp= new WeatherDisplay();
		
		return new String[]{disp.getTemperature(),disp.getHumidity(),disp.getWindSpeed()};
	}
}
