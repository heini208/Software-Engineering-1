
public interface ControllerIF {
	
	Parkhaus enter(String[] params);
	Parkhaus leave(String[] params) throws Exception;
	Parkhaus getParkhaus();
	
	
}
