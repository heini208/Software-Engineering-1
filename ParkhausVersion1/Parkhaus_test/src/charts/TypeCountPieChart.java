/**
 *@author 
 * PaidDurationChart implementiert Chart interface 
 * Methode update || Sendet die neuen Werte an die Klassenvariable values
 * Methode buildChart || Erzeugt ein neues Chart aus den geupdateten values 
 */


package charts;
import grundklassen.Parkhaus;
import grundklassen.Statistiken;
import grundklassen.StatsIterator;
import interfaceklassen.ChartIF;

// Ursprüngliches Familie Pie chart


public class TypeCountPieChart implements ChartIF {
	
	
	//Klassenvariable
	private Parkhaus p;
	private String[] labels = {"Any","Frau","Behinderung","Familie"};
	private int[] values=new int[4];
	private Statistiken stats ;
	
	// Frau , Familie , Behinderung , Any 
	
	
	//Konstruktor
	public TypeCountPieChart(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
	}
	


	//buildChart || Erzeugt ein neues Chart aus den geupdateten values 
	@Override
	public String buildChart() {
		
		String ausgabe = PieChartBuilder.BuildPieChart(labels, values);
		return ausgabe;
	}



	//update || Sendet die neuen Werte an die Klassenvariable an values
	@Override
	public void update() {
		StatsIterator it = new StatsIterator(stats,7);
		String client = "";
		
		
		while(it.hasNext()) {
			client = it.next();
			if(client.equals("Any")) {
				values[0]++;
			}
			else if(client.equals("Frau")) {
				values[1]++;
			}
			else if(client.equals("Behinderung")) {
				values[2]++;
			}
			else if(client.equals("Familie")) {
				values[3]++;
			}
		}
	}

	//Setter Getter
	public void setParkhausFromTypeCountPieChart(Parkhaus p) {
		this.p = p;
	}
	
	public Parkhaus getParkhausFromTypeCountPieChart() {
		return p;
	}
	
	public void setvalues (int[] v) {
		this.values = v;
	}
	
	public int[] getvalues() {
		return values;
	}



}
