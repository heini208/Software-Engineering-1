/**
 * @author 
 * interface Klasse f�r Statistiken
 */

package interfaceklassen;

public interface StatistikenIF {
	public double getSum();
	public String[] toStringArray(int index);
	public double getAvg(); 
	public void aktualisieren(CarIF c);
}
