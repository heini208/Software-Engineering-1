package Interface;
import java.util.List;

import GrundKlassen.Parkhaus;

public interface ParkhausIF {


	int getParked();
	public Parkhaus leave(String[] params)throws Exception;
	public int enter(String[] params);
	List<CarIF> getParkhaus();
	public Parkhaus clearall();
}
