package Einnamahmen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GrundKlassen.Parkhaus;
import GrundKlassen.Statistiken;
import GrundKlassen.StatsIterator;

public abstract class EinnahmenProX {
	protected Parkhaus p;
	protected List<Double> einnahmen = new ArrayList<Double>();;
	protected List<String> tage = new ArrayList<String>();
	protected Statistiken stats;
	protected String daydate;
	protected int index = 0;
	private int iterateIndex = 0;

	public final void update() {
		stats = spezifizieren();
		Iterator<String> si = new StatsIterator(stats,2);
		Iterator<String> sj = new StatsIterator(stats,4);
		
		for(int i = 0; i < iterateIndex; i++) {
			si.next();
			sj.next();
		}

		while (si.hasNext()) {
			iterateIndex++;
			daydate = formatDate(si.next());

			if (index == 0 & tage.size() ==0) {
				tage.add(daydate);
				einnahmen.add(Double.valueOf(sj.next()));

			}else if(!tage.contains(daydate)) {

				tage.add(daydate);
				einnahmen.add(Double.valueOf(sj.next()));
				index++;
				continue;

			} else {
				double einnahme = einnahmen.get(index);
				einnahme += Double.valueOf(sj.next());
				einnahmen.set(index, einnahme);
				einnahme = 0;
			}

		}
	}
	
	//einschubmethoden
	protected abstract Statistiken spezifizieren();
	protected abstract String formatDate(String data);
}
