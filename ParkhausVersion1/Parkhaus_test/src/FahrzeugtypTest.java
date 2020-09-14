import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FahrzeugtypTest {
	String[] params0 = {"enter","1","1593279158223","200","20","de7b7abc55d8035c556a1ab48d717d88","#75b53d","9","Normal","PKW"};
	String[] params1 = {"enter","1","1593279158223","200","20","de7b7abc55d8035c556a1ab48d717d88","#75b53d","9","Normal","Pickup"};
	String[] params2 = {"enter","1","1593279158223","200","20","de7b7abc55d8035c556a1ab48d717d88","#75b53d","9","Normal","Motorrad"};
	
	CarIF car1 = new Car(params0);
	CarIF car2 = new Car(params1);
	CarIF car3 = new Car(params2);
	
	@Test
	void test_carConstructor() {

		car1.setPaid(car1.getPaid()*Fahrzeugtyp.getInstance(car1.getType()).getMultiplicator());
		car2.setPaid(car2.getPaid()*Fahrzeugtyp.getInstance(car2.getType()).getMultiplicator());
		car3.setPaid(car3.getPaid()*Fahrzeugtyp.getInstance(car3.getType()).getMultiplicator());
		
		assertEquals(20,car1.getPaid());
		assertEquals(60,car2.getPaid());
		assertEquals(10,car3.getPaid());
	}
	
	@Test
	void test_setType() {
		
		car1.setType("SUV");
		car2.setType("Quad");
		car3.setType("PKW");
		
		car1.setPaid(car1.getPaid()*Fahrzeugtyp.getInstance(car1.getType()).getMultiplicator());
		car2.setPaid(car2.getPaid()*Fahrzeugtyp.getInstance(car2.getType()).getMultiplicator());
		car3.setPaid(car3.getPaid()*Fahrzeugtyp.getInstance(car3.getType()).getMultiplicator());
		
		System.out.println();
		assertEquals(40,car1.getPaid());
		assertEquals(20,car2.getPaid());
		assertEquals(20,car3.getPaid());
	}
}
