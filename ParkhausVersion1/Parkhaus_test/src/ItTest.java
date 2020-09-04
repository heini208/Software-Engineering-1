import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ItTest {

	@Test
	void test() {
		Statistiken s = new Statistiken(new Parkhaus());
		String[] reiter = {"carnum","startTime", "0.2","duration",
				"paid","ticket", "space", "client","type"
				};
		String[] reiter2 = {"carnum","startTime", "leaveTime","duration",
				"paid","ticket", "space","client", "type"
				};
		List<String[]> stats = new ArrayList<String[]>();
		stats.add(reiter);
		stats.add(reiter);
		stats.add(reiter2);
		s.setStatistik(stats);
		StatsIterator it = new StatsIterator(s,2);
		
		
		assertEquals("0.2", it.next());
		assertEquals("leaveTime", it.next());
		assertEquals(false, it.hasNext());
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
