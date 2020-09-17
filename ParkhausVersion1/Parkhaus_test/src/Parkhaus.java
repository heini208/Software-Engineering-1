import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Parkhaus extends ParkhausPublisher implements ParkhausIF  {
	
	private List<CarIF> cars;
	private boolean isFull;
	private float currentTime;
	private Statistiken stats;
	private float price;
	private String[] plaetze = {"Any","Frau", "Behinderung", "Familie","Motorrad"};
	private int[] pAnzahl = {0,80,85,90,95,105};
	private boolean[] parkplatzBelegung = new boolean[pAnzahl[pAnzahl.length-1]];
	
	
	


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
	public boolean[] getParkplatzBelegung() {
		return parkplatzBelegung;
	}


	public void setParkplatzBelegung(boolean[] parkplatzBelegung) {
		this.parkplatzBelegung = parkplatzBelegung;
	}
	
	public Statistiken getStats() {
		return stats;
	}
	public boolean isFull() {
		for(boolean b: parkplatzBelegung ) {
			if(!b) {
				isFull= false;
				return isFull;
			}
			
		}
		isFull = true;
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
	public void setPlaetze(String[] plaetze) {
		this.plaetze = plaetze;
	}
	public String[] getPlaetze() {
		return plaetze;
	}
	public void setPAnzahl(int[] pAnzahl) {
		this.pAnzahl = pAnzahl;
	}
	public int[] getPAnzahl() {
		return pAnzahl;
	}
	@Override
	public List<CarIF> getParkhaus() {
		return cars;
	}
	public void setParkhaus(List<CarIF> cars) {
		this.cars = cars;
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
	//set getter end
	

	//leave und enter
	public Parkhaus leave(String[] params) throws Exception {
		if ( getParked() == 0 ) {
			throw new Exception("Parkhaus_is_Empty");	
		}
		int index = -1;
		for(CarIF c : cars) {
			
			if(c.getcarnum()==Integer.parseInt(params[1])) {
				
				index= cars.indexOf(c);
				
				
			}
		}
		
		Car currentcar = new Car(params);
		
		currentcar.setPaid(currentcar.getPaid()*Fahrzeugtyp.getInstance(currentcar.getType()).getMultiplicator());
		
		stats.aktualisieren(currentcar);
		update();
		System.out.println("removed: " + (currentcar.getSpace()-1));
		cars.remove(index);
		parkplatzBelegung[currentcar.getSpace()-1] = false;
		System.out.println(Arrays.toString(cars.toArray()));
		return this;
	}
	
	public int enter(String[] params) {
		int space = 0;
		int typeClient = 9;
		int x = 0;
		//boolean taken = false;
		for (int i = 0;i<plaetze.length;i++ ) {
			
			if (params[typeClient].equals(plaetze[i])) {
				for (int j=pAnzahl[i]+1 ;j<pAnzahl[i+1]+1;j++) {
					
					x++;
					if ( parkplatzBelegung[j-1]) {
						if (j == pAnzahl[i+1] && j!=pAnzahl[1]) {
							j =0;
						}else if (j == pAnzahl[1]) {
							//Parkhaus Voll
							System.out.println("Parkhaus ist voll");
							
							return 1;
						}
						//taken = false;
						continue;
					}else {
						
					//free Space found
					space = j;
					parkplatzBelegung[j-1] =true;
					params[7] = "" + space;
					System.out.println("new car");
					System.out.println("space final: " + space);
					cars.add(new Car(params));
					
					return space;
					
					}
				}
			}
			else if(i==plaetze.length-1) {
				if ( typeClient== 9) {
				typeClient = 8;
				i =-1;
				}
				else if ( typeClient==8) {
					System.out.println("Undefined Type");
					return 1;
				}
			}
			
	
		}
		return 1;
	}
		
	
	
	
	

	

	//?? alles mit //* makierte würde ich löschen
	Predicate<Integer> isNull = (position -> cars.get(position) == null);
	private int numCars;

	/*@Override
	public boolean isFree(int platz) {
		return isNull.test(platz);
	}*/
	
	//besagt nur welcher parkplatz welches auto belegt macht keinen Sinn,
	//da unsere autos eine getSpace methode haben
	/*public int findCar(CarIF car) {
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
*/
	
	public Parkhaus clearall() {
		
		this.cars.clear();
		this.currentTime=0;
		this.isFull = false;
		this.numCars = 0;
		parkplatzBelegung = new boolean[pAnzahl[pAnzahl.length-1]];
		return this;
		
	}
}
