import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author fiqa
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperatureJasin = remoteSensorJasin.getTemperature();
			int currentTemperatureAyerKeroh = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTemperatureJasin + " Celcius");
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperatureAyerKeroh + " Celcius");
			
			// Monitoring temperature for a specific day in Jasin
			String day = "Tuesday";
			int temperatureJasin = remoteSensorJasin.getTemperature(day);
			//To display temperature with specific day
			System.out.println("Temperature in Jasin on " + day + " is " + temperatureJasin + " Celcius\n");
			
			// Monitoring temperature for a specific day in AyerKeroh
			String day1 = "Saturday";
			int temperatureAyerKeroh = remoteSensorAyerKeroh.getTemperature(day1);
			//To display temperature with specific day
			System.out.println("Temperature in Ayer Keroh on " + day1 + " is " + temperatureAyerKeroh + " Celcius\n");
			
			// Monitor average temperature in Jasin
			int averageTemperatureJasin = remoteSensorJasin.getAverageTemperature();
			System.out.println("Average Temperature in Jasin on " + day + " is " + averageTemperatureJasin + " Celcius\n");
			
			// Monitor average temperature in Ayer Keroh
			int averageTemperatureAyerKeroh = remoteSensorAyerKeroh.getAverageTemperature();
			System.out.println("Average Temperature in Ayer Keroh on " + day + " is " + averageTemperatureAyerKeroh + " Celcius\n");
			
		} catch (RemoteException | NotBoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
