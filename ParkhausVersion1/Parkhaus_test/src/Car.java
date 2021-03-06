import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

public class Car implements CarIF {
	
	private double duration;
	private long startTime;
	private long leaveTime;
	private int carnum;
	private double paid;
	private String ticket;
	private int space;
	private String type = "any";
	
	
	
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
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	

	public Car(String[] params) {
		if (!params[3].equals("_")) {
			duration = Double.parseDouble(params[3]);
			 leaveTime = Long.parseLong(params[2]) + Long.parseLong(params[3]);
			 paid = Double.parseDouble(params[4]);
		}
		 
		 
		 startTime = Long.parseLong(params[2]);
		 ticket = params[5];
		 space = Integer.parseInt(params[7]);
		 carnum = Integer.parseInt(params[1]);
	}

	public String[] carToString() {
		String[] carValues = new String[8];
		carValues[0] = "C"+ getcarnum();
		carValues[1] = ""+ getStartTime();
		carValues[2] = ""+ getLeaveTime();
		carValues[3] = ""+ getDuration()/1000;
		carValues[4] = ""+ getPaid()/100;
		carValues[5] = ""+ getSpace();
		carValues[6] = getTicket();
		carValues[7] = getType();
		return carValues;
	}
}
