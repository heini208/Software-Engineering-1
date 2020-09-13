import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Parkhaus extends ParkhausPublisher implements ParkhausIF  {
	
	private List<CarIF> cars;
	private boolean isFull;
	private String[][] parkplatzBelegung;
	private float currentTime;
	private Statistiken stats;
	private boolean[] belegungVoll = new boolean[5];
	private float price;
	private String[] plaetze = {"Any","Frau", "Behinderung", "Familie","Motorrad"};
	private int[] pAnzahl = {0,80,85,90,95,100};

	
	
	//Constructors
	public Parkhaus() {
		cars = new ArrayList<>();
		stats = new Statistiken(this);
		/*parkplatzBelegung = new String[5][2];
		
		for(int j = 0; j < parkplatzBelegung[0].length; j++) {
			parkplatzBelegung[0][j] = "n";
			if(j < 80)
				parkplatzBelegung[1][j] = "Any";
			else if (j < 85) {
				parkplatzBelegung[1][j] = "Motorrad";
			} else if (j < 90){
				parkplatzBelegung[1][j] = "Frau";
			} else if (j < 95){
				parkplatzBelegung[1][j] = "Behindert";
			} else {
				parkplatzBelegung[1][j] = "Familie";
			}
		}*/
		
		belegungVoll[0] = false;
		belegungVoll[1] = false;
		belegungVoll[2] = false;
		belegungVoll[3] = false;
		belegungVoll[4] = false;
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
		//parkplatzBelegung[0][currentcar.getSpace()-1] = "n";
		
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
	
	public int enter(String[] params) {
		int space = 0;
		int typeClient = 9;
		boolean taken = false;
		for (int i = 0;i<plaetze.length;i++ ) {
			
			if (params[typeClient].equals(plaetze[i])) {
				for (int j=pAnzahl[i]+1 ;j<pAnzahl[i+1]+1;j++) {
					for(CarIF c : cars) {
						
						if(c.getSpace()==j) {
							taken = true;
						}				
					}
					
					if ( taken== true) {
						if (j == pAnzahl[i+1]) {
							j =0;
						}else if (j == pAnzahl[1]) {
							//Parkhaus Voll
							System.out.println("Parkhaus ist voll");
							isFull = true;
							return 1;
						}
						taken = false;
						continue;
					}else {
						isFull = false;	
					//free Space found
					space = j;
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
	private int numCars;

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
