package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author fiqa
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private HashMap<String, Integer> weekTemperature;
	
	public TemperatureSensorManager() throws RemoteException {
		super();
		
		//To load temperatures
		weekTemperature = new LinkedHashMap<String, Integer>();
		loadWeekTemperature();
		
	}

	/**
	* This method creates temperature data for a week
	*/
	private void loadWeekTemperature() {
	
		// Data preparation
		String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
		int temperatures[] = {32, 31, 33, 35, 36, 33, 33};
	
		// Load data into map
		for (int index=0; index < days.length; index++)
			weekTemperature.put(days[index],
			Integer.valueOf(temperatures[index]));
	}
	
	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}

	@Override
	public int getTemperature(String day) throws RemoteException {
		// TODO Auto-generated method stub
		return weekTemperature.get(day);
	}
	
	@Override
	public int getAverageTemperature() throws RemoteException {
	
		int totalTemperature = 0;
	
		Set<String> days = weekTemperature.keySet();
	
		for (String day:days)
			totalTemperature += weekTemperature.get(day);
	
		int average = totalTemperature / days.size();
	
		return average;
	}

	
}
