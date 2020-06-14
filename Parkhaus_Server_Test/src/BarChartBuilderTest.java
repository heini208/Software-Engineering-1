import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


class BarChartBuilderTest {

	
	
	@Test
	void test() {
		
		
		String[][] TestArray = {{"c1","c2","c3","c4"},{"15","10","11","18"},{"Duration"},};
		String TestString = "{\"data\":[{\"x\":[\"c1\",\"c2\",\"c3\",\"c4\"],\"name\":\"Duration\",\"y\":[\"15\",\"10\",\"11\",\"18\"],\"type\":\"bar\"}]}";
		assertEquals(TestString,BarChartBuilder.BuildBarChart(TestArray[0],new String[][] {TestArray[1]},TestArray[2]));
		
		String[][] TestArray2 = {{"c1","c2","c3","c4"},{"77","10","100","18"},{"77","10","100","18"},{"Duration","Duration 2"},};
		String TestString2 = "{\"data\":[{\"x\":[\"c1\",\"c2\",\"c3\",\"c4\"],\"name\":\"Duration\",\"y\":[\"77\",\"10\",\"100\",\"18\"],\"type\":\"bar\"},{\"x\":[\"c1\",\"c2\",\"c3\",\"c4\"],\"name\":\"Duration 2\",\"y\":[\"77\",\"10\",\"100\",\"18\"],\"type\":\"bar\"}]}";
		assertEquals(TestString2,BarChartBuilder.BuildBarChart(TestArray2[0],new String[][] {TestArray2[1],TestArray2[2]},TestArray2[3]));
		
		String TestString3 = "{\"data\":[{\"x\":[\"c1\",\"c2\",\"c3\",\"c4\"],\"name\":\"Duration\",\"y\":[\"77\",\"10\",\"100\",\"18\"],\"type\":\"bar\"},{\"x\":[\"c1\",\"c2\",\"c3\",\"c4\"],\"y\":[\"77\",\"10\",\"100\",\"18\"],\"type\":\"bar\"}]}" ;
		assertEquals(TestString3,BarChartBuilder.BuildBarChart(TestArray2[0],new String[][] {TestArray2[1],TestArray2[2]},TestArray[2]));
		
		
	}
		
		
		
		
	}


