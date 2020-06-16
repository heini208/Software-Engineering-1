import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ItTest {

	@Test
	void test() {
		Statistiken s = new Statistiken(new Parkhaus());
		String[] reiter = {"carnum","startTime", "leaveTime","duration",
				"paid","ticket", "space", "type"
				};
		List<String[]> stats = new ArrayList<String[]>();
		stats.add(reiter);
		stats.add(reiter);
		s.setStatistik(stats);
		StatsIterator it = new StatsIterator(s,2);
		
		
		assertEquals("leaveTime", it.next());
		assertEquals("leaveTime", it.next());
		assertEquals(false, it.hasNext());
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
