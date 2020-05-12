
public class Car implements Car_if {
	
	private float duration;
	private float startTime;
	private float leaveTime;
	private float paid;
	private int ticket;
	
	
	
	
	public Car(float startTime) {
		this.startTime = startTime;
	}
	public Car() {
		
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public float getPaid() {
		return paid;
	}
	public void setPaid(float paid) {
		this.paid = paid;
	}
	
	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration ;
	}

	public float getStartTime() {
		return startTime;
	}

	public void setStartTime(float time) {
		this.startTime = time;
	}

	public float getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(float time) {
		this.leaveTime = time;
	}
	
	
}
