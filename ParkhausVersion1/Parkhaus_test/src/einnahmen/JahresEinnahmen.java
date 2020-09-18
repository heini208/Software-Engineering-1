package einnahmen;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import grundklassen.Parkhaus;
import grundklassen.Statistiken;

public class JahresEinnahmen extends EinnahmenProX {

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
	
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	
	public JahresEinnahmen(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		this.update();
	}
	
	@Override
	protected Statistiken spezifizieren() {
		return p.getStats();
	}

	@Override
	protected String formatDate(String data) {
		return sdf.format(new Date( Long.parseLong(data)));
	}

}