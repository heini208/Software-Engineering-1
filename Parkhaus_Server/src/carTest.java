import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class carTest {
	private Car car0,car2;
	private float time1,time2,time3;
	
	@BeforeEach
	public void setUp() throws Exception{
		
		time1 = 5;
		time2 = 10;
		time3 = 15;
		
		car0 = new Car(time1);
		car2 = new Car();
		
		
	}
	
	@Test
	void getsetDurationTest() {
		car2.setDuration(20);
		assertEquals(20,car2.getDuration());
	}

}
