package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import einnahmen.JahresEinnahmen;
import einnahmen.MonatsEinnahmen;
import einnahmen.TagesEinnahmen;
import einnahmen.WochenEinnahmen;
import grundklassen.Parkhaus;

class SchabloneTest {

	@Test
	void test() {
		Parkhaus p = new Parkhaus();
		List<String[]> stats = new ArrayList<String[]>();
		String[] reiter = {"carnum","startTime", "leaveTime","duration",
				"paid","ticket", "space", "client","type"
				};
		stats.add(reiter);
		String[] car1 = {"","","604800000","","123","","","",""};
		stats.add(car1);
		String[] car2 = {"","","800000000","","456","","","",""};
		stats.add(car2);
		String[] car3 = {"","","1300000000","","200","","","",""};
		stats.add(car3);
		String[] car4 = {"","","1350000000","","200","","","",""};
		stats.add(car4);
		
		
		p.getStats().setStatistik(stats);
		WochenEinnahmen we = new WochenEinnahmen(p);
		TagesEinnahmen te = new TagesEinnahmen(p);
		MonatsEinnahmen me = new MonatsEinnahmen(p);
		JahresEinnahmen je = new JahresEinnahmen(p);
		
		String[] car5 = {"","","1380400000","","200","","","",""};
		stats.add(car5);
		we.update();
		te.update();
		
		String[] car6 = {"","",""+(1380400000+2629000000L),"","200","","","",""};
		stats.add(car6);
		
		me.update();
		me.update();
		
		String[] car7 = {"","",""+(1380400000+36550000000L),"","200","","","",""};
		stats.add(car7);
		
		je.update();
		
		
		List<Double> testListWe = new ArrayList<Double>();
		testListWe.add(579.0);
		testListWe.add(600.0);
		
		List<Double> testListTe = new ArrayList<Double>();
		testListTe.add(123.0);
		testListTe.add(456.0);
		testListTe.add(400.0);
		testListTe.add(200.0);
		
		List<Double> testListMe = new ArrayList<Double>();
		testListMe.add(1179.0);
		testListMe.add(200.0);
		
		List<Double> testListJe = new ArrayList<Double>();
		testListJe.add(1379.0);
		testListJe.add(200.0);

		assertEquals(testListWe.toString(), we.getEinnahmen().toString());
		assertEquals(testListTe.toString(), te.getEinnahmen().toString());
		assertEquals(testListMe.toString(), me.getEinnahmen().toString());
		assertEquals(testListJe.toString(), je.getEinnahmen().toString());
		
	}

}
