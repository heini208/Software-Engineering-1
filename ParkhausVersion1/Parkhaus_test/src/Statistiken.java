import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Statistiken{
	Iterator<String> i;
	Parkhaus parkhaus;
	private String[] reiter = {"carnum","startTime", "leaveTime","duration",
			"paid","ticket", "space","client","type"
			};
	List<String[]> stats = new ArrayList<String[]>();
	
	
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
	
	
	//getter
	public List<String[]> getStatistik(){
		return this.stats;
	}
	
	public void setStatistik(List<String[]> stats) {
		this.stats = stats;
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
	
	/*
	public double getSum() {
		
			
		Stream<String[]> stream = stats.stream();
		double sum =
				stream .flatMap(list -> Arrays.asList(
						list[Arrays.asList(stats.get(0)).indexOf("Preis")])
						.stream())
				.skip(1)
				.mapToDouble(list -> Double.parseDouble(list))
				.reduce(0, Double::sum);
		
		return sum;
		
	}*/
	
	
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
