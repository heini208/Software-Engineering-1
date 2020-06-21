
public class PaidDurationChart implements ChartIF {
	
	Parkhaus p;
	String[] duration;
	String[] paid;
	Statistiken stats;
	
	
	public PaidDurationChart(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
	}
	
	@Override
	public void update() {
		stats = p.getStats();
		duration = stats.toStringArray(3);
		paid = stats.toStringArray(4);
		
		
	}

	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(stats.toStringArray(0), new String[][] {duration,paid}, new String[] {"duration", "paid"});
		return ausgabe;
	}

}
