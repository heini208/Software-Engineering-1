import java.util.List;

public interface ParkhausIF {

	boolean isFree(int platz);

	int getParked();

	List<CarIF> getParkhaus();
	

}
