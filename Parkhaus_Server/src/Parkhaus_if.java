import java.util.List;

public interface Parkhaus_if {
	
	public void enter(Car_if c) throws Exception;
	public Car_if[] getParkhaus();
	
	public void leave(Car_if car) throws Exception;

	public int getParked();
	public boolean isFree(int platz);
	
	public void setCurrentTime(float time);
	
	public float getCurrentTime();
	public List<String[]> getStats(); 
	
	
}
