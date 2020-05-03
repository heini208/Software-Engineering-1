import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class se1_223Test {
	se1_223 obj0;
	se1_223 obj1;
	String[][] depend0 = {{ "A" , "C" }, { "C", "D" }, { "B", "C" }}; //transitivitaet
	String[][] depend1 = null;
	
	@BeforeEach
	void setUp() throws Exception {
		obj0 = new Sort(depend0);
		obj1 = new Sort(depend1);
	}
	
	@DisplayName("Überprüft ob Sequence korrekt ist")
	@Test
	void testIsWellSorted() {
		String[] seq0 = {"A", "B", "C", "D"};
		String[] seq1 = {"C", "B", "A", "D"};
		String[] seq2 = {"A", "B", "A", "C"};
		String[] seq3 = {"A", "C", "B", "D"};
		assertEquals(true,obj0.isWellSoreted(seq0));
		assertEquals(false,obj0.isWellSoreted(seq1));
		assertEquals(false,obj0.isWellSoreted(seq2));
		assertEquals(false,obj0.isWellSoreted(seq3));
		assertEquals(true,obj1.isWellSoreted(seq0));
	}

}
