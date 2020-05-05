import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class parkhausTest {
	
	private Parkhaus_if haus1,haus2;
	private Car_if car0,car1,car2;
	
	private int pltz;
	
	@BeforeEach
	public void setUp() throws Exception{
		haus1 = new Parkhaus(10);
		car0 = new Car();
		car1 = new Car();
		car2 = new Car();
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		haus1 = null;
	}

	@Test
	
	
	void testEnter() {
		try {
			haus1.enter(car0);
			haus1.enter(car1);
			haus1.enter(car2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(car0, haus1.getParkhaus()[0]);
		assertEquals(car1, haus1.getParkhaus()[1]);
		assertEquals(car2, haus1.getParkhaus()[2]);
		
		haus2 = new Parkhaus(1);
		try {
			haus2.enter(car0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertThrows(Exception.class,()->{
			haus2.enter(car1);
		});
		
	}
	@Test
	void testIsFree() {
		assertEquals(true, haus1.isFree(0));
		assertEquals(true, haus1.isFree(1));
		try {
			haus1.enter(car0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(false, haus1.isFree(0));
		assertEquals(true, haus1.isFree(1));
	}
	
	@Test
	void testgetParkhaus() {
		Car_if[] autos = new Car_if[10];
		assertEquals(10, haus1.getParkhaus().length);
		assertNotEquals(null,haus1.getParkhaus());
		for (int i=0; i<haus1.getParkhaus().length;i++) {
			assertEquals(autos[i], haus1.getParkhaus()[i]);
		}
	}
	
	@Test

	void testGetParked() {
		try {
			haus1.enter(car0);
			haus1.enter(car1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(2,haus1.getParked());
	}

	@Test

	void testLeave() throws Exception {
		
		haus1.enter(car0);
		haus1.enter(car1);
		haus1.enter(car2);
		haus1.leave(car1);
		
		assertEquals(true, haus1.isFree(1));
		assertEquals(false, haus1.isFree(0));
		assertEquals(false, haus1.isFree(2));
		assertEquals(2,haus1.getParked());
		
		haus2= new Parkhaus(1);
		
		Exception e = assertThrows(Exception.class,()->{
			haus2.leave(car1);
		});
		
		assertEquals("Parkhaus_is_empty", e.getMessage());
		
		haus2.enter(car0);
		
		e = assertThrows(Exception.class,()->{
			haus2.leave(car1);
		});
		
		assertEquals("Car_not_found", e.getMessage());
		
		
		
	}

	

	

	
}
