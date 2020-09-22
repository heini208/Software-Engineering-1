/**
 * @author 
 * JahresEinnahmen Berechnet die einnahmen von einem Jahr in einer Liste
 * Methode spezifizieren || gibt die Werte aus 
 * Methode formatDate || Formatiert das Datum 
 */

package einnahmen;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import grundklassen.Parkhaus;
import grundklassen.Statistiken;

public class JahresEinnahmen extends EinnahmenProX {

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
	

	//Konstruktor 
	public JahresEinnahmen(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		this.update();
	}
	
	//spezifizieren || gibt die Werte aus 
	@Override
	protected Statistiken spezifizieren() {
		return p.getStats();
	}

	//formatDate || Formatiert das Datum 
	@Override
	protected String formatDate(String data) {
		return sdf.format(new Date( Long.parseLong(data)));
	}
	
	//Getter Setter
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	

}