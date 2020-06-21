import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class WochenEinnahmenTest {

	@Test
	void test() {
		Parkhaus p = new Parkhaus();
		List<String[]> stats = new ArrayList<String[]>();
		String[] reiter = {"carnum","startTime", "leaveTime","duration",
				"paid","ticket", "space", "type"
				};
		stats.add(reiter);
		String[] car1 = {"","","604800000","","123","","",""};
		stats.add(car1);
		String[] car2 = {"","","800000000","","456","","",""};
		stats.add(car2);
		String[] car3 = {"","","1300000000","","200","","",""};
		stats.add(car3);
		String[] car4 = {"","","1350000000","","200","","",""};
		stats.add(car4);
		String[] car5 = {"","","1380400000","","200","","",""};
		stats.add(car5);
		p.getStats().setStatistik(stats);
		WochenEinnahmen t = new WochenEinnahmen(p);
		List<Double> testArray = new ArrayList<Double>();
		testArray.add(579.0);
		testArray.add(600.0);

		List<String> testDate = new ArrayList<String>();
		testDate.add("1970-W02");
		testDate.add("1970-W03");
		
		
		assertEquals(testDate.toString(),t.getTage().toString());
		assertEquals(testArray.toString(),t.getEinnahmen().toString());
		
		String testChart = "{\"data\":[{\"x\":[\"1970-W02\",\"1970-W03\"],\"name\":\"Wocheneinnahmen\",\"y\":[\"579.0\",\"600.0\"],\"type\":\"bar\"}]}";
		
		assertEquals(testChart, t.buildChart());
	}

}
