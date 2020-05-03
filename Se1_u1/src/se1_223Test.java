import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class se1_223Test {
	se1_223 obj0;
	String[][] depend = {{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
	
	@BeforeEach
	void setUp() throws Exception {
		obj0 = new Sort(depend);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@DisplayName("Überprügt ob Sequence korrekt sit")
	@Test
	void testIsWellSorted() {
		String[] seq = {"A", "B", "C", "D"};
		assertEquals(true,obj0.isWellSoreted(seq));
	}

}
