import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Parkhaus extends ParkhausPublisher implements ParkhausIF  {
	
	private List<CarIF> cars;
	private boolean isFull;
	private String[][] parkplatzBelegung;
	private float currentTime;
	private int numCars;
	private float price;
	private Statistiken stats;
	private boolean[] belegungVoll = new boolean[4];
	

	
	
	//Constructors
	public Parkhaus() {
		cars = new ArrayList<>();
		stats = new Statistiken(this);
		parkplatzBelegung = new String[2][100];
		
		for(int j = 0; j < parkplatzBelegung[0].length; j++) {
			parkplatzBelegung[0][j] = "n";
			if(j < 75)
				parkplatzBelegung[1][j] = "Normal";
			else if (j < 83) {
				parkplatzBelegung[1][j] = "Frau";
			} else if (j < 91){
				parkplatzBelegung[1][j] = "Behindert";
			} else {
				parkplatzBelegung[1][j] = "Familie";
			}
		}
		
		belegungVoll[0] = false;
		belegungVoll[1] = false;
		belegungVoll[2] = false;
		belegungVoll[3] = false;
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
		
		//freigeben des Parkplatz in der Belegung
		parkplatzBelegung[0][currentcar.getSpace()-1] = "n";
		
		//wenn parkplätze voll waren
		switch (params[8]){
			case "Normal": belegungVoll[0] = false; break;
			case "Frau" :belegungVoll[1] = false; break;
			case "Familie" : belegungVoll[2] = false; break;
			case "Behinderung" : belegungVoll[3] = false; break;
		}
		
		System.out.println("removed: " + (currentcar.getSpace()-1));
		cars.remove(index);
		System.out.println(Arrays.toString(cars.toArray()));
		return this;
	}
	
	
	public int enter(String[] params){
		int space = Integer.parseInt(params[7]);
		Iterator<CarIF> i = cars.listIterator();
		Random r = new Random();
		int count;
		
		if ( cars== null ) {
			cars =new ArrayList<CarIF>();
		}
		
		while(i.hasNext()) {
			if((i.next().getTicket()).equals(params[5])) {
				i.remove();
			}
		}
		
		// beim implementieren von Parkplatzbelegung
		// beachten das Auto
		// nur aufzunehmen wenn ein Parkplatz frei ist!
		
		if (params[8].equals("Frau") && (!belegungVoll[1])) {
			System.out.println("belegungVoll[1]: " + belegungVoll[1] );
			
				count = 0;
				while(parkplatzBelegung[0][space-1].equals("y")) {
					System.out.println("Enter While frau");
					System.out.println("space: " + space);
					space = r.nextInt(5) + 86;
					System.out.println("space new: " + space);
				}
				
				parkplatzBelegung[0][space-1] = "y";
				
				for (int j = 85; j < 90; j++) {
					if(parkplatzBelegung[0][j].equals("n"))
						count++;
				}
				
				System.out.println("count: " + count);
				
				if(count == 0) {
					belegungVoll[1] = true;
				}
		
		} else if (params[8].equals("Behinderung") && (!belegungVoll[2]) ){
			System.out.println("belegungVoll[2]: " + belegungVoll[2] );
			
				count = 0;
				while(parkplatzBelegung[0][space-1].equals("y")) {
					System.out.println("Enter While behinderung");
					System.out.println("space: " + space);
					space = r.nextInt(5) + 91;
					System.out.println("space new: " + space);
				}
				
				parkplatzBelegung[0][space-1] = "y";
				
				for (int j = 90; j < 95; j++) {
					if(parkplatzBelegung[0][j].equals("n"))
						count++;
				}
				System.out.println("count: " + count);
				if(count == 0) {
					belegungVoll[2] = true;
				}
			
		} else if (params[8].equals("Familie") && (!belegungVoll[3])){
			System.out.println("belegungVoll[3]: " + belegungVoll[3] );
			
				count = 0;
				while (parkplatzBelegung[0][space-1].equals("y")) {
					System.out.println("Enter While familie");
					System.out.println("space: " + space);
					space = r.nextInt(5) + 96;
					System.out.println("space new: " + space);
				}
				
				parkplatzBelegung[0][space-1] = "y";
				
				for (int j = 95; j < 100; j++) {
					if(parkplatzBelegung[0][j].equals("n"))
						count++;
				}
				System.out.println("count: " + count);
				if(count == 0) {
					belegungVoll[3] = true;
				}
			
			
		} else if (!belegungVoll[0]){
			 
				System.out.println("belegungVoll[0]: " + belegungVoll[0] );
				if (space > 85)
					space = r.nextInt(85)+1;
			
					count = 0;
					while(parkplatzBelegung[0][space-1].equals("y")) {
						System.out.println("Enter While normal");
						System.out.println("space: " + space);
						space = r.nextInt(85)+1;
						System.out.println("space new: " + space);
					}
					
					parkplatzBelegung[0][space-1] = "y";
					
					for (int j = 0; j < 85; j++) {
						if(parkplatzBelegung[0][j].equals("n"))
							count++;
					}
					
					if(count == 0) {
						belegungVoll[0] = true;
					}
			
				
		} else {
			return space;
		}
		
		parkplatzBelegung[0][space-1] = "y";
		params[7] = "" + space;
		System.out.println("new car");
		System.out.println("space final: " + space);
		cars.add(new Car(params));
		
		return space;
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
