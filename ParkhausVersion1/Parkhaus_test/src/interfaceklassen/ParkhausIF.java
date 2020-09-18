package interfaceklassen;
import java.util.List;

import grundklassen.Parkhaus;

public interface ParkhausIF {


	int getParked();
	public Parkhaus leave(String[] params)throws Exception;
	public int enter(String[] params);
	List<CarIF> getParkhaus();
	public Parkhaus clearall();
}
