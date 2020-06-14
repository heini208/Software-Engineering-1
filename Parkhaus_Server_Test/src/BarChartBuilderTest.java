import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


class BarChartBuilderTest {

	
	
	@Test
	void test() {
		
//		if ( getCars()!= null) {
//
//
//			String carnums = "\"Car_" + getCars().get(0).getcarnum()+"\"";
//			String carvalues = ""+(getCars().get(0).getDuration())/1000;
//			Iterator<CarIF> iterator = getCars().listIterator(1);
//
//			while(iterator.hasNext()){
//				CarIF c = iterator.next();
//				System.out.println(carnums);
//
//				carnums += ",\"Car_" + c.getcarnum()+"\"";
//				carvalues += ","+ c.getDuration()/1000;
//			}
//
//
//			String root = "{\"data\":[{\"x\":["+ carnums +"],\"y\":["+carvalues+"],\"type\":\"bar\"}]}";
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println(root);
//			
		
		String[][] TestArray = {{"1","8","6","4"},{"3","10","2","4"},{"5","10","2","4"},{"4","10","2","4"}};
		double[][] TestArray2 = {{1,8,6,4},{3,10,2,4},{5,10,2,4},{4,10,2,4}};
		System.out.println(BarChartBuilder.BuildBarChart(TestArray[0],new double[][]  {TestArray2[0]},TestArray[2]));
			
		}
		
		
		
		
	}


