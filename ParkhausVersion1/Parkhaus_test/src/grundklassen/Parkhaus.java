/**
 * @author 
 * Parkhaus erstellt ein Parkhaus mit Autos und den Belegungen
 * Methode clearall || setzt das Parkhaus zurück 
 * Methode enter || Ein Auto tritt dem Parkhaus bei 
 * Methode leave || Eine Auto verlässt das Parkhaus 
 */

package grundklassen;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import interfaceklassen.CarIF;
import interfaceklassen.ParkhausIF;

public class Parkhaus extends ParkhausPublisher implements ParkhausIF  {
	
	//Klassenvariablen
	private List<CarIF> cars;
	private boolean isFull;
	private float currentTime;
	private Statistiken stats;
	private String[] plaetze = {"Any","Frau", "Behinderung", "Familie","Motorrad"};
	private int[] pAnzahl = {0,80,85,90,95,105};
	
	
	
	//Konstruktor
	public Parkhaus() {
		cars = new ArrayList<>();
		stats = new Statistiken(this);
		
	}
	//Konstruktor
	public Parkhaus(List<CarIF> cars) {
		this.cars = cars;
		stats = new Statistiken(this);
	}
	
	
	
	//setter getter
	
	public Statistiken getStats() {
		return stats;
	}
	public boolean isFull() {
		System.out.println("TESTETSTEST " + getParked() +"  " + pAnzahl[pAnzahl.length-1]);
		if (getParked() == pAnzahl[pAnzahl.length-1]) {
			isFull = true;
		}else {
			isFull = false;
		}
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
		return cars.size();
		
	}
	//set getter end
	

	//leave || Eine Auto verlässt das Parkhaus 
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
		if(index == -1) {
			return this;
		}
		Car currentcar = new Car(params);
		
		currentcar.setPaid(currentcar.getPaid()*Fahrzeugtyp.getInstance(currentcar.getType()).getMultiplicator());
		
		stats.aktualisieren(currentcar);
		update();
		System.out.println("removed: " + (currentcar.getSpace()-1));
		cars.remove(index);
		System.out.println(Arrays.toString(cars.toArray()));
		return this;
	}
	
	//enter || Ein Auto tritt dem Parkhaus bei 
	public int enter(String[] params) {
		int typeClient = plaetze.length;
		
		// Heraus finden des des Auto/ClientTyps mit priorität auf Autotyp z.B Motorrad
		int type = IntStream.range(0, typeClient)
			.filter(i -> plaetze[i].equals(params[9]))
			.findFirst()
			.orElse(
					IntStream.range(0,typeClient)
					.filter(i -> plaetze[i].equals(params[8]))
					.findFirst()
					.orElse(-1));
			
		if(type == -1) {
			//kein auto gefunden mit diesen ClientTyp
			System.out.println("Car type not found");
			return 1;	
		}
			
			// Besetze Parkplaetze finden
		List<Integer> taken = cars.stream()
				.mapToInt(c -> c.getSpace())
				.boxed()
				.collect(Collectors.toList());
			// Freie Parkplaetze finden
		int space = IntStream.range(1,pAnzahl[pAnzahl.length-1]+1)
				.filter(p-> !taken.contains(p) )
				.filter(p-> p > pAnzahl[type] && p<= pAnzahl[type+1])
				.min()
					// kein freier Parkplatz gefunden Stream auffüllen
					// und nach freien Any Parkplatz suchen
				.orElse(
						IntStream.range(1,pAnzahl[pAnzahl.length-1]+1)
						.filter(p-> !taken.contains(p) )
						.filter(p-> p<=pAnzahl[1] )
						.min()
						// kein valider Parkplatz frei
						.orElse(-1));
		System.out.println(space);
		if(space == -1) {
			System.out.println("no Free Space");
			return 1;
		}
					
		params[7] = "" + space;
		System.out.println("new car");
		System.out.println("space final: " + space);
		cars.add(new Car(params));			
		
		return space;
	}
		
	
	//clearall || setzt das Parkhaus zurück 
	public Parkhaus clearall() {
		
		this.cars.clear();
		this.currentTime=0;
		this.isFull = false;
		return this;
		
	}
}
