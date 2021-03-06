import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TageseinnahmenTest {

	@Test
	void test() {
		Parkhaus p = new Parkhaus();
		List<String[]> stats = new ArrayList<String[]>();
		String[] reiter = {"carnum","startTime", "leaveTime","duration",
				"paid","ticket", "space", "type"
				};
		stats.add(reiter);
		String[] car1 = {"","","1592672800190","","0.3","","",""};
		stats.add(car1);
		String[] car2 = {"","","1592672800290","","0.5","","",""};
		stats.add(car2);
		String[] car3 = {"","","1692672800190","","200","","",""};
		stats.add(car3);
		String[] car4 = {"","","1692672800290","","200","","",""};
		stats.add(car4);
		String[] car5 = {"","","1692672800300","","200","","",""};
		stats.add(car5);
		p.getStats().setStatistik(stats);
		TagesEinnahmen t = new TagesEinnahmen(p);
		List<Integer> testArray = new ArrayList<Integer>();
		testArray.add(200);
		testArray.add(600);
		
		List<String> testDate = new ArrayList<String>();
		testDate.add("2020-06-20");
		testDate.add("2023-08-22");
		
		assertEquals(testDate.toString(),t.getTage().toString() );
		assertEquals(testArray.toString(),t.getEinnahmen().toString());
		
		String testChart = "{\"data\":[{\"x\":[\"2020-06-20\",\"2023-08-22\"],\"name\":\"Tageseinnahmen\",\"y\":[\"200\",\"600\"],\"type\":\"bar\"}]}";
		
		assertEquals(testChart, t.buildChart());
	}

}
