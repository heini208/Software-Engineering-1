package einnahmen;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import charts.BarChartBuilder;
import grundklassen.Parkhaus;
import grundklassen.Statistiken;
import interfaceklassen.ChartIF;

public class TagesEinnahmen extends EinnahmenProX implements ChartIF {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	
	public TagesEinnahmen(Parkhaus p) {
		this.p = p;
		stats = spezifizieren();
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
		
		return BarChartBuilder.BuildBarChart(days, new String[][] {einnahmenarr}, new String[] {"Tageseinnahmen"});
		
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
