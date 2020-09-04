import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Parkhaus extends ParkhausPublisher implements ParkhausIF  {
	
	private List<CarIF> cars;
	private boolean isFull;
	private float currentTime;
	private int numCars;
	private float price;
	private Statistiken stats;
	

	
	
	//Constructors
	public Parkhaus() {
		cars = new ArrayList<>();
		stats = new Statistiken(this);
	}
	public Parkhaus(float price) {
		cars = new ArrayList<>();
		this.price = price;
		stats = new Statistiken(this);
	}
	public Parkhaus(List<CarIF> cars) {
		this.cars = cars;
		stats = new Statistiken(this);
	}

	//Constructors end
	
	
	
	//setter getter
	public Statistiken getStats() {
		return stats;
	}
	public boolean isFull() {
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
	//set getter end
	

	
	public Parkhaus leave(String[] params) throws Exception {
		if ( getParked() == 0 ) {
			throw new Exception("Parkhaus_is_Empty");	
		}
		int index = 99999;
		for(CarIF c : cars) {
			
			if(c.getcarnum()==Integer.parseInt(params[1])) {
				
				index= cars.indexOf(c);
				
				
			}
		}
		
		Car currentcar = new Car(params);
		currentcar.setPaid(currentcar.getPaid()*Fahrzeugtyp.getInstance(currentcar.getType()).getMultiplicator());
		
		stats.aktualisieren(currentcar);
		update();
		
		cars.remove(index);
		System.out.println(Arrays.toString(cars.toArray()));
		return this;
	}
	
	
	public Parkhaus enter(String[] params){
		
		if ( cars== null ) {
			cars =new ArrayList<CarIF>();
		}

		String ticket = params[5];
		Iterator<CarIF> i = cars.listIterator();
		while(i.hasNext()) {
			if((i.next().getTicket()).equals(ticket)) {
				i.remove();
			}

		}
		
		// beim implementieren von Parkplatzbelegung
		//beachten das Auto
		//nur aufzunehmen wenn ein Parkplatz frei ist!
		cars.add(new Car(params));

		return this;
	}
	
	
	
	@Override
	public List<CarIF> getParkhaus() {
		return cars;
	}
	

	@Override
	public int getParked() {
		int parked = 0;
		for (int i =0 ; i < cars.size(); i++) {
				if( cars.get(i) != null ) {
					parked++;
				}
			}
		return parked;
		
	}

	
	Predicate<Integer> isNull = (position -> cars.get(position) == null);

	@Override
	public boolean isFree(int platz) {
		return isNull.test(platz);
	}
	

	public int findCar(CarIF car) {
		Stream<CarIF> stream = cars.stream();
		int test = 0;
		
		try {
			test =  stream.filter(cars -> cars != null)
					.filter(cars -> cars.equals(car))
					.mapToInt(cars -> cars.getSpace())
					.findFirst()
					.getAsInt();
		} catch (Exception e) {
			return -1;
		}

		return test;
	}

	
	public Parkhaus clearall() {
		
		this.cars=null;
		this.currentTime=0;
		this.isFull = false;
		this.numCars = 0;
		return null;
		
	}
}
