import java.util.Arrays;
import java.util.List;

public class BelegtProzentChart implements ChartIF{
	Parkhaus p;
	List<CarIF> cars;
	//missing motorrad
	String[] typ = {"Any","Familie","Behinderung","Frau"};
	float[] werte = new float[5];
	String[] finalWerte = new String[5];
	
	int samples= 0;
	public BelegtProzentChart(Parkhaus p){
	this.p = p;
	
	p.addChart(this);
	this.update();
	}
	
	@Override
	public void update() {
		cars = p.getParkhaus();
		//Parkplatz Art als Variable aus Parkhaus auslesbar machen um sie hier zu verwenden jetzt erstmal hardcodiert (am besten im array dann kann finalWerte mit for schleife belegt werden)
		for(CarIF c : cars) {
			
			if(c.getSpace()<86) {
				werte[0]++;
			}
			else if (c.getSpace()>85 && c.getSpace()<91) {
				werte[3]++;
			}
			else if (c.getSpace()>90 && c.getSpace()< 96){
				werte[2]++;
			}
			else if (c.getSpace()>95) {
				werte[1]++;
			}
			}
		samples++;
		finalWerte[0] = String.valueOf((werte[0]/(85*samples))*100);
		finalWerte[1] = String.valueOf((werte[1]/(5*samples))*100); 
		finalWerte[2] = String.valueOf((werte[2]/(5*samples))*100);
		finalWerte[3] = String.valueOf((werte[3]/(5*samples))*100);
		System.out.println("TestTestTest:   " + finalWerte[0] +"   " +werte[0] + "  " +samples);
		
		
	}

	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(typ, new String[][] {finalWerte}, new String[] {"Percent"});
		return ausgabe;
	}

}
