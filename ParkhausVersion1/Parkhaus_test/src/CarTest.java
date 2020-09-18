import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class CarTest {

	String[] car1 = {"","35","1600422662045","64","73","4a2d91becbf3694af44eec43edb9d22e","#881a60","1","Any","PKW"};
	String[] car2 = {"","77","1600422661652","_","_","35e0fcb292f36838372eb2559dc9c7e7","#c58684","2","Any","PKW"};
	String[] car3 = {"","78","1600422661445","_","_","2604758f5cbcdafc13aae1d39cb8c9cf","#c1cccd","81","Frau","PKW"};
	
	
	Car c1 = new Car(car1);
	Car c2 = new Car(car2);
	Car c3 = new Car(car3);
	
	
	@Test
	void Stats() {
		
		c2.setDuration(554);
		assertEquals(554,c2.getDuration());
	
		}

	@Test
	void Calculate() {
		
		c1.setStartTime(334);
		c1.setLeaveTime(555);
		assertEquals(73.0,c1.getPaid());
		
		c1.getDuration();
		c1.getLeaveTime();
		c1.getPaid();
		c1.getStartTime();
		
		
		
	}
	
}
