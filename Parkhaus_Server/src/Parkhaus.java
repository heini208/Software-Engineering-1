import java.util.*;

public class Parkhaus implements Parkhaus_if {
	private Car_if[] cars;
	private boolean isFull;
	private float currentTime;
	private int numCars;
	
	private float price;
	private String[] reiter = {"Parkplatz","Ticket","Von", "Bis", "Dauer","Preis"};
	List<String[]> stats = new ArrayList<String[]>();
		
	public Parkhaus(int max) {
		stats.add(reiter); 
		cars = new Car_if[max];
	}
	public Parkhaus(int max, float price) {
		this.price = price;
		cars = new Car_if[max];
		stats.add(reiter); 
	}
	public Parkhaus() {
		cars = new Car_if[20];
		stats.add(reiter); 	
	}
	
	//setter getter
	public boolean isFull() {
		/*if ( getParked() == cars.length-1) {
			return true;
		}
		return false; */
		
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	public void setCurrentTime(float time) {
		currentTime = time;
	}
	public float getCurrentTime() {
		return currentTime;
	}
	
	@Override
	public Car_if[] getParkhaus() {
		return cars;
		
	}
	public List<String[]> getStats(){
		return this.stats;
	}
	
	
	// andere Methoden
	@Override
	public void enter(Car_if c) throws Exception {
		
		c.setStartTime(currentTime);
		
		if (isFull()) {
			throw new Exception("Parkhaus_is_full");
		
		}
		
	for (int i =0 ; i < cars.length ; i++) {
		if ( isFree(i)) {
			cars[i] = c;
			// ticket nummer zuweisen
			c.setTicket(numCars);
			numCars ++;
			if ( i == cars.length-1) {
				setFull(true);
			}
			break;
			
		}
	}
	}
	@Override
	public void leave(Car_if car) throws Exception {
		
		
		if( getParked() == 0) {
			throw new Exception("Parkhaus_is_empty");
			
		}
		

		
		for (int i=0; i < cars.length; i++) {
			if (car.equals(cars[i])) {
				cars[i] =null;
				
				car.setLeaveTime(currentTime);
				// duration berechnen
				car.setDuration(currentTime-car.getStartTime());
				// preis berechnen
				car.setPaid(car.getDuration()*price);
				// car in statistik übertragen
				
				String[] carStats= {""+i,""+car.getTicket() ,""+car.getStartTime(), ""+car.getLeaveTime(), ""+car.getDuration(), ""+car.getPaid()};
			
				stats.add(carStats);
				return;
			}
		}
		
		throw new Exception("Car_not_found");
	}

	@Override
	public int getParked() {
		int parked = 0;
		for (int i =0 ; i < cars.length ; i++) {
				if( cars[i] != null ) {
					parked++;
				}
			}
		return parked;
		
	}

	@Override
	public boolean isFree(int platz) {
		if(cars[platz]== null) {
			return true;
		}else {
			return false;
		}
	}

}
