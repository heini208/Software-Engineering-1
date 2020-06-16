import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


class BarChartBuilderTest {

	
	
	@Test
	void test() {
			String[][] TestArray = {{"1","8","6","4"},{"3","10","2","4"},{"5","10","2","4"},{"4","10","2","4"}};
			System.out.println(BarChartBuilder.BuildBarChart(TestArray[0],new String[][]{TestArray[0]},TestArray[2]));
			
		}
		
		
		
		
	}


