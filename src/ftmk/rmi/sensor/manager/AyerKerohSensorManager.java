package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import ftmk.rmi.sensor.TemperatureSensor;

/**
* This class represents a temperature sensor in Ayer Keroh
* @author fiqa
*
*/

public class AyerKerohSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private HashMap<String, Integer> weekTemperature;
	
	public AyerKerohSensorManager() throws RemoteException {

		super();

		//To load temperature
		weekTemperature = new LinkedHashMap<String, Integer>();
		loadWeekTemperature();
	}
	
	/**
	* This method creates temperature data for a week
	*/
	private void loadWeekTemperature() {
	
		//Data preparation
		String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
		int temperatures[] = {35, 37, 33, 38, 36, 32, 31};
	
		// Load data into map
		for (int index=0; index < days.length; index++)
			weekTemperature.put(days[index], 
				Integer.valueOf(temperatures[index]));
	}

	@Override
	public int getTemperature() throws RemoteException {

		return 34;
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