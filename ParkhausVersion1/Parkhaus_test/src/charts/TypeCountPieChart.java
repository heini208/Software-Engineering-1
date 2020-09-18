package charts;
import grundklassen.Parkhaus;
import grundklassen.Statistiken;
import grundklassen.StatsIterator;
import interfaceklassen.ChartIF;

// Ursprüngliches Familie Pie chart


public class TypeCountPieChart implements ChartIF {
	
	Parkhaus p;
	String[] labels = {"Any","Frau","Behinderung","Familie"};
	int[] values=new int[4];
	Statistiken stats ;
	
	// Frau , Familie , Behinderung , Any , Motorrad
	
	public TypeCountPieChart(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
	}
	


	@Override
	public String buildChart() {
		
		String ausgabe = PieChartBuilder.BuildPieChart(labels, values);
		return ausgabe;
	}



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


	public void setParkhaus(Parkhaus p) {
		this.p = p;

	}
	public Parkhaus getParkhaus() {
		return p;
	}
	
	public void setvalues (int[] v) {
		this.values = v;

	}
	public int[] getvalues() {
		return values;
	}



}
