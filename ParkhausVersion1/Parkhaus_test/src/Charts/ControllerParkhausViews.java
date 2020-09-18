package Charts;
import java.util.List;

import Einnamahmen.TagesEinnahmen;
import GrundKlassen.Parkhaus;
import Interface.CarIF;
import Interface.ChartIF;
import Interface.ControllerIF;

public class ControllerParkhausViews implements ControllerIF {
	
	private Parkhaus parkhaus = new Parkhaus();
	
	public ControllerParkhausViews() {
		new PaidDurationChart(parkhaus);
		//new TagesEinnahmen(parkhaus);
		new TypeCountPieChart(parkhaus);
		new BelegtProzentChart(parkhaus);
	}
	
	public void addChart(ChartIF chart) {
		parkhaus.addChart(chart);			
	}
	
	public void removeChart(ChartIF chart) {
		parkhaus.removeChart(chart);
	}

	@Override
	public int enter(String[] params) {
		return parkhaus.enter(params);
	}

	@Override
	public Parkhaus leave(String[] params) throws Exception {
		return parkhaus.leave(params);
	}

	@Override
	public List<CarIF> getListOfCars() {
		return this.parkhaus.getParkhaus();
	}

	public Parkhaus getParkhaus() {
		return this.parkhaus;
	}
	
}
