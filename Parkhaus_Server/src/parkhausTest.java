import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

//Parkhaus 
class parkhausTest {
	
	private Parkhaus_if haus1,haus2;
	private Car_if car0,car1,car2;
	

	
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
	
	@Test
	void testEnterTimes() throws Exception {
		haus1.setCurrentTime(10);
		haus1.enter(car0);
		
		
		assertEquals(10,car0.getStartTime());
		
	}
	
	@Test
	void testLeaveTimes() throws Exception {
		haus1.setCurrentTime(10);
		haus1.enter(car0);
		haus1.setCurrentTime(15);
		haus1.leave(car0);
		
		assertEquals(15,car0.getLeaveTime());
		assertEquals(5,car0.getDuration());	
	}
	
	@Test
	void testPrices() throws Exception  {
		Parkhaus_if preisHaus = new Parkhaus(10,1);
		Parkhaus_if preisHaus2 = new Parkhaus(10,0.2f);
		
		preisHaus.setCurrentTime(10);
		preisHaus.enter(car0); 
		preisHaus.setCurrentTime(20);
		preisHaus.leave(car0);
		
		assertEquals(10,car0.getPaid());
		
		preisHaus2.setCurrentTime(10);
		preisHaus2.enter(car0); 
		preisHaus2.setCurrentTime(13);
		preisHaus2.leave(car0);
		
		assertEquals(0.6f,car0.getPaid());
		
	}
	@Test
	void testStats() throws Exception {
		Parkhaus_if preisHaus = new Parkhaus(10,1);
		
		preisHaus.setCurrentTime(10);
		preisHaus.enter(car0); 
		preisHaus.setCurrentTime(20);
		preisHaus.leave(car0);
		preisHaus.enter(car1);
		preisHaus.setCurrentTime(25);
		preisHaus.enter(car2);
		preisHaus.setCurrentTime(30);
		preisHaus.leave(car2);
		preisHaus.leave(car1);
		String[] statsCar0= {"0","0","10.0","20.0","10.0", "10.0"}; 
		String[] statsCar1= {"0","1","20.0","30.0","10.0","10.0"};
		String[] statsCar2= {"1","2","25.0","30.0","5.0","5.0"};
		
		for ( int i= 0; i<preisHaus.getStats().get(1).length ; i++) {
			assertEquals(statsCar0[i],preisHaus.getStats().get(1)[i]);
		}
		String[] reiter = {"Parkplatz","Ticket","Von", "Bis", "Dauer","Preis"};
		for ( int i= 0; i<preisHaus.getStats().get(0).length ; i++) {
			assertEquals(reiter[i],preisHaus.getStats().get(0)[i]);
			assertEquals(statsCar2[i],preisHaus.getStats().get(2)[i]);
			assertEquals(statsCar1[i],preisHaus.getStats().get(3)[i]);
			
		}
		
		
		
		
	}
	
	
	

	

	

	
}
