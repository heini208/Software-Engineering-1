import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MVCTest {

	@Test
	void testController() {
		String[] params = {"1","2345", "2345", "2345", "2345", "ticket", "2345","2345","Normal","PKW"};
		CarIF auto = new Car(params);
		ControllerIF controller = new ControllerParkhausViews();
		
		//assertion tests
		assertNotNull(controller.getParkhaus());
		assertArrayEquals(auto.carToString(), controller.enter(params).getParkhaus().get(0).carToString());
		try {
			assertEquals(0, controller.leave(params).getParked());;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
