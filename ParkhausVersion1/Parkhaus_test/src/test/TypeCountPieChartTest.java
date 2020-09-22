/**
 * @author 
 * Test für TypeCountPieChart
 */

package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import charts.ControllerParkhausViews;
import charts.TypeCountPieChart;
import interfaceklassen.ControllerIF;

class TypeCountPieChartTest {
	ControllerIF controller = new ControllerParkhausViews();
	
	String[] params = {"enter","7","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","PKW","7"};
	String[] params2 = {"enter","7","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","Motorrad","7"};
	// dein Parkhaus bleibt leer du enterst nie.
	TypeCountPieChart chart = new TypeCountPieChart(controller.getParkhaus());
	
	@Test
	void test() {
		 
		System.out.println(chart.getvalues());
			chart.update();
			System.out.println(chart.getvalues());
			assertEquals("25.0",chart.getvalues());
		}
		
	
	

}
	


