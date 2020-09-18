package GrundKlassen;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Charts.ControllerParkhausViews;
import Interface.CarIF;
import Interface.ControllerIF;

class MVCTest {

	@Test
	void testController() {
		String[] params = {"enter","81","1600259554175","_","_","e5db2d3f13b20477398f3a09cfcf88f8","#0368bf","1","Any","PKW","81"};
		CarIF auto = new Car(params);
		ControllerIF controller = new ControllerParkhausViews();
		
		//assertion tests
		assertNotNull(controller.getParkhaus());
		controller.enter(params);
		assertArrayEquals(auto.carToString(), controller.getListOfCars().get(0).carToString());
		try {
			assertEquals(0, controller.leave(params).getParked());;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
