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
	
	public static List<CarIF> addcars(String[] params , List<CarIF> cars){
		
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

		cars.add(new Car(params));

		return cars;
	}
	

	
	public static String[][] carStats (List<CarIF> cars ){
		
		String[][] stats = new String[7][cars.size()];
		
		
			for(int j = 0 ; j<cars.size();j++) {
				stats[0][j] = Double.toString(cars.get(j).getDuration()/1000);
				stats[1][j] = Long.toString(cars.get(j).getStartTime());
				stats[2][j] = Long.toString(cars.get(j).getLeaveTime());
				stats[3][j] = "c" + Integer.toString(cars.get(j).getcarnum());
				stats[4][j] = Double.toString(cars.get(j).getPaid()/100);
				stats[5][j] = cars.get(j).getTicket();
				stats[6][j] = Integer.toString(cars.get(j).getSpace());
				
			}
		
		
		
		return stats;
	}
	
}
