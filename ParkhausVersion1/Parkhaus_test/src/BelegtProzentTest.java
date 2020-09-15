import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BelegtProzentTest {
	ControllerIF controller = new ControllerParkhausViews();
	String[] params = {"enter","7","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","PKW","7"};
	String[] params2 = {"enter","7","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","Motorrad","7"};
	BelegtProzentChart chart = new BelegtProzentChart(controller.getParkhaus());
	
	@Test
	void test() {
		
		for(int i=0 ; i<40 ; i++) {
		controller.enter(params);
		}
		chart.setParkhaus(controller.getParkhaus());
		chart.update();
		assertEquals("25.0",chart.getFinalWerte()[0]);
		
		
		for(int i=0 ; i<3 ; i++) {
			controller.enter(params2);
			}
		chart.setParkhaus(controller.getParkhaus());
		chart.update();
		assertEquals("20.0",chart.getFinalWerte()[4]);
		
		System.out.println(chart.buildChart());
	}
	
	@Test
	void chartTest(){
		for(int i=0 ; i<70 ; i++) {
			controller.enter(params);
			}
		chart.setParkhaus(controller.getParkhaus());
		chart.update();
			for(int i=0 ; i<4 ; i++) {
				controller.enter(params2);
				}
			chart.setParkhaus(controller.getParkhaus());
			chart.update();
			for(int i=0 ; i<4 ; i++) {
				controller.enter(params2);
				}
			chart.setParkhaus(controller.getParkhaus());
			chart.update();
			System.out.println(chart.buildChart());
			String expected = "{\"data\":[{\"x\":[\"Any\",\"Frau\",\"Behinderung\",\"Familie\",\"Motorrad\"],\"name\":\"Percent\",\"y\":[\"66.5625\",\"0.0\",\"0.0\",\"0.0\",\"40.0\"],\"type\":\"bar\"}]}";
			assertEquals(expected,chart.buildChart());
	}

}
