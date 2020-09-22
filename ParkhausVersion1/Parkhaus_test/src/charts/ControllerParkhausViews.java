/**
 * @author   
 * ControllerParkhausViews implementiert Controller interface 
 * Methode addChart || Fügt Chart hinzu 
 * Methode removeChart || Entfernt Diagramm
 * Methode enter || Fahrzeug fährt in das Parkhaus 
 * Methode leave || Fahrzeug verlässt das Parkhaus 
 */


package charts;
import java.util.List;

import einnahmen.TagesEinnahmen;
import grundklassen.Parkhaus;
import interfaceklassen.CarIF;
import interfaceklassen.ChartIF;
import interfaceklassen.ControllerIF;

public class ControllerParkhausViews implements ControllerIF {
	
	//Klassenvariablen  
	private Parkhaus parkhaus = new Parkhaus();
	
	//Konstruktor 
	public ControllerParkhausViews() {
		new PaidDurationChart(parkhaus);
		new TagesEinnahmen(parkhaus);
		new TypeCountPieChart(parkhaus);
		new BelegtProzentChart(parkhaus);
	}
	
	//addChart || Fügt Chart hinzu 
	public void addChart(ChartIF chart) {
		parkhaus.addChart(chart);			
	}
	
	//removeChart || Entfernt Diagramm
	public void removeChart(ChartIF chart) {
		parkhaus.removeChart(chart);
	}

	//enter || Fahrzeug fährt in das Parkhaus 
	@Override
	public int enter(String[] params) {
		return parkhaus.enter(params);
	}

	//leave || Fahrzeug verlässt das Parkhaus
	@Override
	public Parkhaus leave(String[] params) throws Exception {
		return parkhaus.leave(params);
	}

	//Getter Setter
	@Override
	public List<CarIF> getListOfCars() {
		return this.parkhaus.getParkhaus();
	}

	public Parkhaus getParkhaus() {
		return this.parkhaus;
	}
	
}
