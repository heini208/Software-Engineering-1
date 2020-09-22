/**
 * @author 
 * Test für PieChartBuilder
 */
package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import charts.PieChartBuilder;

class PieChartBuilderTest {

	
	
	
//	Erster Test auf Formatierung 
	
	@Test
	void test() {
		int[] values = {10,2,6,5};
		
		String[] labels = {"Any","Frau","Behinderung","Familie"};
		
		String expectedString = 
				"{\"data\":[{\"values\":[10,2,6,5],"
				+ "\"type\":\"pie\","
				+ "\"labels\":[\"Any\",\"Frau\",\"Behinderung\",\"Familie\"]}]}";
				
		String resultString = PieChartBuilder.BuildPieChart(labels,values);
		
		assertEquals(expectedString, resultString);
	}
}


