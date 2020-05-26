import java.util.List;

public class Car implements CarIF {
	
	private int duration;
	private long startTime;
	private long leaveTime;
	private int carnum;
	public int getcarnum() {
		return carnum;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
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
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
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
	private int paid;
	private String ticket;
	private int space;
	public Car(String[] params) {
		if (!params[3].equals("_")) {
			duration = Integer.parseInt(params[3]);
			 leaveTime = Long.parseLong(params[2]) + Long.parseLong(params[3]);
			 paid = Integer.parseInt(params[4]);
		}
		 
		 
		 startTime = Long.parseLong(params[2]);
		 ticket = params[5];
		 space = Integer.parseInt(params[7]);
		 carnum = Integer.parseInt(params[1]);
	}
	
	
	
}
