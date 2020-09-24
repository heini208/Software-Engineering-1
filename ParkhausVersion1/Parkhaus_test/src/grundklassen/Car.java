/**
 * @author 
 * Car erstellt ein Auto f�r das Parkhaus
 * Methode carToString || Formatiert die Werte aus CarValues in einen String
 */

package grundklassen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import interfaceklassen.CarIF;

public class Car implements CarIF {
	
	//Klassenvariablen
	private double duration;
	private long startTime;
	private long leaveTime;
	private int carnum;
	private double paid;
	private String ticket;
	private int space;
	private String type;
	private String client;
	private String colour;
	
	 //Konstruktor
		public Car(String[] params) {
			if (!params[3].equals("_")) {
				leaveTime = Long.parseLong(params[2]);
				duration = Double.parseDouble(params[3]);
				paid = Double.parseDouble(params[4]) ;
				
			} else {
				startTime = Long.parseLong(params[2]);
			}
			
			carnum = Integer.parseInt(params[1]); 
			ticket = params[5];
		    space = Integer.parseInt(params[7]);
			client = params[8];
			type = params[9];
		}
	
	//getter setter
	public int getcarnum() {
		return carnum;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(long leaveTime) {
		this.leaveTime = leaveTime;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@Override
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	//carToString || Formatiert die Werte aus CarValues in einen String
	public String[] carToString() {
		String[] carValues = new String[9];
		carValues[0] = "C"+ getcarnum();
		carValues[1] = ""+ getStartTime();
		carValues[2] = ""+ getLeaveTime();
		carValues[3] = ""+ getDuration()/1000;
		carValues[4] = ""+ getPaid()/100;
		carValues[5] = ""+ getSpace();
		carValues[6] = getTicket();
		carValues[7] = getClient();
		carValues[8] = getType();
		return carValues;
	}
}
