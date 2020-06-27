import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FahrzeugtypTest {
	String[] params = {"enter","1","1593279158223","200","20","de7b7abc55d8035c556a1ab48d717d88","#75b53d","9"};
	

	Car car1 = new Car(params);
	Car car2 = new Car(params);
	Car car3 = new Car(params);
	
	@Test
	void test() {
		car1.setType("PKW");
		car2.setType("Pickup");
		car3.setType("Zweirad");
		
		
		car1.setPaid(car1.getPaid()*Fahrzeugtyp.getInstance(car1.getType()).getMultiplicator());
		car2.setPaid(car2.getPaid()*Fahrzeugtyp.getInstance(car2.getType()).getMultiplicator());
		car3.setPaid(car3.getPaid()*Fahrzeugtyp.getInstance(car3.getType()).getMultiplicator());
		
		System.out.println();
		assertEquals(20,car1.getPaid());
		assertEquals(40,car2.getPaid());
		assertEquals(100,car3.getPaid());
		
	}

}
