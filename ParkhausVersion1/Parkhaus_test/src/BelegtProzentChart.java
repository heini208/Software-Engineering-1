import java.util.Arrays;
import java.util.List;

public class BelegtProzentChart implements ChartIF{
	private Parkhaus p;
	private List<CarIF> cars;

	private String[] typ;
	private int[] anzahl;
	private float[] werte;
	private String[] finalWerte;
	private int samples= 0;
	
	public BelegtProzentChart(Parkhaus p){
	this.p = p;
	anzahl = p.getPAnzahl();
	typ = p.getPlaetze();
	werte = new float[typ.length];
	finalWerte = new String[typ.length];
	
	p.addChart(this);
	this.update();
	}
	public String[] getFinalWerte(){
		return finalWerte;
	}
	public void setFinalWerte(String[] finalWerte) {
		this.finalWerte = finalWerte;
	}
	public void setParkhaus(Parkhaus p) {
		this.p = p;
	}
	public Parkhaus getParkhaus() {
		return p;
	}
	
	
	
	@Override
	public void update() {
		cars = p.getParkhaus();
		
		for(CarIF c : cars) {
			for (int i=0;i<anzahl.length; i++) {
				if (c.getSpace()>anzahl[i] && c.getSpace()<anzahl[i+1]) {
					werte[i]++;
				}
			}
			
			
			}
		samples++;
		for(int i= 0; i<finalWerte.length;i++){
			finalWerte[i] = String.valueOf((werte[i]/((anzahl[i+1]-anzahl[i])*samples))*100);
		}
		
		
		
		
	}

	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(typ, new String[][] {finalWerte}, new String[] {"Percent"});
		return ausgabe;
	}

}
