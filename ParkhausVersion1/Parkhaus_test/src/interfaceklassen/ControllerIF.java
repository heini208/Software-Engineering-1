/**
 * @author 
 * interface Klasse f�r Controlle
 */

package interfaceklassen;
import java.util.List;

import grundklassen.Parkhaus;

public interface ControllerIF {
	
	public void removeChart(ChartIF chart);
	public void addChart(ChartIF chart);
	int enter(String[] params);
	Parkhaus leave(String[] params) throws Exception;
	Parkhaus getParkhausFromController();
	List<CarIF> getListOfCars();
	
}
