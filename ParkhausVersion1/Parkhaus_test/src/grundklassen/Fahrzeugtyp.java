package grundklassen;
import java.util.*;

public class Fahrzeugtyp {
    
    private static Map<String, Fahrzeugtyp> instances;
    static{
        instances = new HashMap<String, Fahrzeugtyp>();
        instances.put("PKW", new Fahrzeugtyp(4, 1));
        instances.put("SUV", new Fahrzeugtyp(12, 2));
        instances.put("Pickup", new Fahrzeugtyp(6, 3));
        instances.put("Motorrad", new Fahrzeugtyp(2, 0.5f));
        instances.put("Trike", new Fahrzeugtyp(4, 1));
        instances.put("Quad", new Fahrzeugtyp(4, 1));
    }

    private double quadratmeter;
    private double priceMultiplicator;
    
    private Fahrzeugtyp(int quadratmeter, float price) {
        this.quadratmeter = quadratmeter;
        this.priceMultiplicator = price;
    }
   
    
    public static Fahrzeugtyp getInstance(String type) {
    	return instances.get(type);
    }

    public double getQuadratmeter() {
        return quadratmeter;
    }

    public double getMultiplicator() {
        return priceMultiplicator;
    }
}