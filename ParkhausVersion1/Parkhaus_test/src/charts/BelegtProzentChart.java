/**
 * @author   
 * BelegtProzentChart implementiert Chart interface 
 * Methode update || Sendet die neuen Werte an die Klassenvariable FinalWerte
 * Methode buildChart || Erzeugt ein neues Chart aus den geupdateten Finalwerten 
 */

package charts;
import java.util.Arrays;
import java.util.List;

import grundklassen.Parkhaus;
import interfaceklassen.CarIF;
import interfaceklassen.ChartIF;


public class BelegtProzentChart implements ChartIF{
	
	//KlassenVariablen 
	private Parkhaus p;
	private List<CarIF> cars;

	private String[] typ;
	private int[] anzahl;
	private float[] werte;
	private String[] finalWerte;
	private int samples= 0;
	
	
	//Konstruktor 
	public BelegtProzentChart(Parkhaus p){
	this.p = p;
	anzahl = p.getPAnzahl();
	typ = p.getPlaetze();
	werte = new float[typ.length];
	finalWerte = new String[typ.length];
	p.addChart(this);
	this.update();
	}
	
	// Getter Setter 
	public String[] getFinalWerte(){
		return finalWerte;
	}
	public void setFinalWerte(String[] finalWerte) {
		this.finalWerte = finalWerte;
	}
	public void setParkhausFromBelegtProzentChart(Parkhaus p) {
		this.p = p;
	}
	public Parkhaus getParkhausFromBelegtProzentChart() {
		return p;
	}
	
	
	
	//update || Sendet die neuen Werte an die Klassenvariable FinalWerte
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
	//buildChart || Erzeugt ein neues Chart aus den geupdateten Finalwerten 
	@Override
	public String buildChart() {
		String ausgabe = BarChartBuilder.BuildBarChart(typ, new String[][] {finalWerte}, new String[] {"Percent"});
		return ausgabe;
	}

}
