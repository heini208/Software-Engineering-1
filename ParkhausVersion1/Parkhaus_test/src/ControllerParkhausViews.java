
public class ControllerParkhausViews implements ControllerIF {
	
	private Parkhaus parkhaus = new Parkhaus();
	
	public ControllerParkhausViews() {
		new PaidDurationChart(parkhaus);
		new TagesEinnahmen(parkhaus);
	}
	
	public void addChart(ChartIF chart) {
		parkhaus.addChart(chart);			
	}
	
	public void removeChart(ChartIF chart) {
		parkhaus.removeChart(chart);
	}

	@Override
	public Parkhaus enter(String[] params) {
		return parkhaus.enter(params);
	}

	@Override
	public Parkhaus leave(String[] params) throws Exception {
		return parkhaus.leave(params);
	}

	@Override
	public Parkhaus getParkhaus() {
		return this.parkhaus;
	}

	
	
}
