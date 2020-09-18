package Interface;
import java.util.List;

import GrundKlassen.Parkhaus;

public interface ControllerIF {
	
	int enter(String[] params);
	Parkhaus leave(String[] params) throws Exception;
	Parkhaus getParkhaus();
	List<CarIF> getListOfCars();
	
}
