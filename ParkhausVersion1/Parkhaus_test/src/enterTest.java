import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class enterTest {
	


	   
	         List<CarIF> cars;
	         String[] plaetze = {"Any","Frau", "Behinderung", "Familie","Motorrad"};
	    	 int[] pAnzahl = {0,80,85,90,95,100};
		     boolean[] parkplatzBelegung = new boolean[pAnzahl[pAnzahl.length-1]];
	         CarIF car1 = new Car(0);
	         CarIF car2 = new Car(3);
	         CarIF car3 = new Car(78);
	         
	     
	

	@Test
	void test() {
		cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        Stream<Integer> stream1 = (Stream)  cars.stream()
						.mapToInt(cars -> cars.getSpace());
        List<Integer> belegt = stream1.collect(Collectors.toList());
				Stream<Integer> stream = (Stream) IntStream.rangeClosed(pAnzahl[0]+1, pAnzahl[pAnzahl.length-1]);
				List<Integer> frei = stream.collect(Collectors.toList());
				frei.removeAll(belegt);
				
				
       
       
       System.out.println(frei.toString());
		fail("Not yet implemented");
	}

}
