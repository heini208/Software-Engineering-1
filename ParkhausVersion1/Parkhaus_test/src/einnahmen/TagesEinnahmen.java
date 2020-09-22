/**
 * @author 
 * TagesEinnahmen Berechnet die einnahmen von einem Tag in einer Liste
 * Methode spezifizieren || gibt die Werte aus 
 * Methode formatDate || Formatiert das Datum 
 * Methode buildChart || Erzeugt ein neues Chart aus den TagesEinnahmen
 */

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

	//Klassenvariablen
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//Konstruktor
	public TagesEinnahmen(Parkhaus p) {
		this.p = p;
		stats = spezifizieren();
		p.addChart(this);
		this.update();
	}
	
	//buildChart || Erzeugt ein neues Chart aus den TagesEinnahmen
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

	//spezifizieren || gibt die Werte aus 
	@Override
	protected Statistiken spezifizieren() {
		return p.getStats();
	}

	//formatDate || Formatiert das Datum 
	@Override
	protected String formatDate(String data) {
		return sdf.format(new Date( Long.parseLong(data)));
	}
	
	//Getter Setter
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	
}
