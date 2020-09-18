package GrundKlassen;
import java.util.ArrayList;
import java.util.List;

import Interface.ChartIF;

public abstract class ParkhausPublisher {

		private List<ChartIF> chart= new ArrayList<ChartIF>() ;
		
		
		public List<ChartIF> getChart(){
			return chart;
		}
		
		public void update() {
			for(int i = 0;i<chart.size(); i++) {
				chart.get(i).update();
			}
		}
		
		public void addChart(ChartIF chart) {
			this.chart.add(chart);			
		}
		
		public void removeChart(ChartIF chart) {
			if (this.chart.contains(chart)) {
				this.chart.remove(chart);
			}
		}
}
