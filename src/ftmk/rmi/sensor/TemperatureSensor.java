package ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface represents temperature sensor
 * 
 * @author fiqa
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	* This method computes average temperature
	* @return average temperature
	* @throws RemoteException
	*/
	public int getAverageTemperature() throws RemoteException;
	
	/**
	* This method gets a temperature for a specific day
	* @param day - requested day
	* @return temperature of the day
	* @throws RemoteException
	*/
	public int getTemperature (String day) throws RemoteException;
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;

}
