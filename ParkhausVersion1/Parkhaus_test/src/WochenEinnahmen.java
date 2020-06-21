import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class WochenEinnahmen extends EinnahmenProX implements ChartIF {
 
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-'W'ww");
	
	
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	
	public WochenEinnahmen(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
	}
	

	@Override
	public String buildChart() {
		
		List<String> einString = einnahmen.stream().map(Object::toString)
                .collect(Collectors.toList());
		String[] einnahmenarr = new String[einString.size()];
		 einnahmenarr = einString.toArray(einnahmenarr);
		
		String[] days = new String[tage.size()];
		days= tage.toArray(days);
		
		return BarChartBuilder.BuildBarChart(days, new String[][] {einnahmenarr}, new String[] {"Wocheneinnahmen"});
		
	}

	@Override
	protected Statistiken spezifizieren() {
		return p.getStats();
	}
	
	@Override
	protected String formatDate(String data) {
		return sdf.format(new Date( Long.parseLong(data)));
	}

}
