import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MonatsEinnahmen extends EinnahmenProX {
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM");
	
	public List<Double> getEinnahmen(){
		return einnahmen;
	}
	
	public List<String> getTage(){
		return tage;
	}
	
	public MonatsEinnahmen(Parkhaus p) {
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
