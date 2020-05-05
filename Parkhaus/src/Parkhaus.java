
public class Parkhaus implements Parkhaus_if {
	private Car_if[] cars;
	private boolean isFull;
	
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

	public Parkhaus() {
		cars = new Car_if[20];

	}
	
	public Parkhaus(int max) {
		
		cars = new Car_if[max];
	}
	
	@Override
	public Car_if[] getParkhaus() {
		return cars;
		
	}
	@Override
	public void enter(Car_if c) throws Exception {
		if (isFull()) {
			throw new Exception("Parkhaus_is_full");
		
		
		}
		
	for (int i =0 ; i < cars.length ; i++) {
		if ( isFree(i)) {
			cars[i] = c;
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
				
				// car in statistik übertragen
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
