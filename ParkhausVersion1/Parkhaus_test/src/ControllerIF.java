import java.util.List;

public interface ControllerIF {
	
	int enter(String[] params);
	Parkhaus leave(String[] params) throws Exception;
	Parkhaus getParkhaus();
	List<CarIF> getListOfCars();
	
}
