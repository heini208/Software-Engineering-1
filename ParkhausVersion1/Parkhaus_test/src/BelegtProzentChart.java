import java.util.Arrays;
import java.util.List;

public class BelegtProzentChart implements ChartIF{
	Parkhaus p;
	List<CarIF> cars;
	//missing motorrad
	String[] typ;
	int[] anzahl;
	float[] werte;
	String[] finalWerte;
	
	int samples= 0;
	public BelegtProzentChart(Parkhaus p){
	this.p = p;
	anzahl = p.getPAnzahl();
	typ = p.getPlaetze();
	werte = new float[typ.length];
	finalWerte = new String[typ.length];
	
	p.addChart(this);
	this.update();
	}
	
	@Override
	public void update() {
		cars = p.getParkhaus();
		//Parkplatz Art als Variable aus Parkhaus auslesbar machen um sie hier zu verwenden jetzt erstmal hardcodiert (am besten im array dann kann finalWerte mit for schleife belegt werden)
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
		
		System.out.println("TestTestTest:   " + finalWerte[0] +"   " +werte[0] + "  " +samples);
		
		
	}

	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(typ, new String[][] {finalWerte}, new String[] {"Percent"});
		return ausgabe;
	}

}
