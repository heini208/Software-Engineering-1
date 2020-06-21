import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.util.Iterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BarChartBuilderTest {

	@DisplayName("takes string matrix returns data as json string correctly")
	@Test
	void testBarChartBuilder() {
			String[][] TestArray = {{"1","8","6","4"},{"3","10","2","4"},{"5","10","2","4"},{"4","10","2","4"}};
			String expectedString = "{\"data\":[{\"x\":[\"1\",\"8\",\"6\",\"4\"],"
					+ "\"name\":\"5\",\"y\":[\"1\",\"8\",\"6\",\"4\"],"
					+ "\"type\":\"bar\"}]}";
			String resultString = BarChartBuilder.BuildBarChart(TestArray[0],new String[][]{TestArray[0]},TestArray[2]);
			
			assertEquals(expectedString, resultString);
	}
}


