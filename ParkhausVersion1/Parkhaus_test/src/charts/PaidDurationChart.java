/**
 * @author 
 * PaidDurationChart implementiert Chart interface 
 * Methode update || Sendet die neuen Werte an die Klassenvariable FinalWerte
 * Methode buildChart || Erzeugt ein neues Chart aus den geupdateten Finalwerten 
 */

package charts;
import grundklassen.Parkhaus;
import grundklassen.Statistiken;
import interfaceklassen.ChartIF;

public class PaidDurationChart implements ChartIF {
	
	//Klassenvariablen 
	private Parkhaus p;
	private String[] duration;
	private String[] paid;
	private Statistiken stats;
	
	
	//Konstruktor
	public PaidDurationChart(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
	}
	
	//Methode update || Sendet die neuen Werte an die Klassenvariable FinalWerte
	@Override
	public void update() {
		stats = p.getStats();
		duration = stats.toStringArray(3);
		paid = stats.toStringArray(4);
		
		
	}

	//Methode buildChart || Erzeugt ein neues Chart aus den geupdateten Finalwerten 
	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(stats.toStringArray(0), new String[][] {duration,paid}, new String[] {"duration", "paid"});
		return ausgabe;
	}

}
