/**
 * @author 
 * Statistiken erstellt Statistiken und gibt stats als variable aus 
 */

package grundklassen;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import interfaceklassen.CarIF;
import interfaceklassen.StatistikenIF;

public class Statistiken implements StatistikenIF{
	
	//Klassenvariablen
	private List<String[]> stats = new ArrayList<String[]>();
	private Iterator<String> i;
	private Parkhaus parkhaus;
	private String[] reiter = {"carnum","startTime", "leaveTime","duration",
			"paid","ticket", "space","client","type"
			};
	
	
	
	//Constructor
	public Statistiken(Parkhaus parkhaus) {
		this.parkhaus  = parkhaus;
		stats.add(reiter);
		String[] carValues = new String[9];
		
		for(CarIF cars : parkhaus.getParkhaus()) {
			carValues = cars.carToString();
			stats.add(carValues);
		}
	}
	
	
	//getter setter
	public List<String[]> getStatistik(){
		return this.stats;
	}
	
	public void setStatistik(List<String[]> stats) {
		this.stats = stats;
	}
	public Iterator<String> getIterator() {
		return i;
	}


	public void setIterator(Iterator<String> i) {
		this.i = i;
	}


	public Parkhaus getParkhausFromStats() {
		return parkhaus;
	}


	public void setParkhausFromStats(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}


	public String[] getReiter() {
		return reiter;
	}


	public void setReiter(String[] reiter) {
		this.reiter = reiter;
	}
	
	
	//returns sum of prices
	public double getSum() {
		i = new StatsIterator(this, 5);
		double sum = 0;
		while(i.hasNext())
			sum += Double.parseDouble(i.next());
		return sum/100;
	}
	
	
	//mapping values to String arrays
	public String[] toStringArray(int index) { //TODO evtl mit String statt int
		String[] values = new String[stats.size()-1];
		i = new StatsIterator(this, index);
		int count = 0;
		while(i.hasNext()) {
			values[count] = i.next();
			count++;
		}
		return values;
	}
	
	
	//returns average of all prices
	public double getAvg() {
		return (stats.size()>1)? getSum()/(stats.size()-1) : 0;
	}
	
	
	//miniobserver für nur ein Objekt
	public void aktualisieren(CarIF c) {
		stats.add(c.carToString());
	}
	public void update() {
		
	}
	
}
