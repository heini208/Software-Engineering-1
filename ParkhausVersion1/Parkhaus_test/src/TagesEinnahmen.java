import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TagesEinnahmen implements ChartIF {
	private Parkhaus p;
	private List<Integer> einnahmen = new ArrayList<Integer>();;
	private List<Date> tage = new ArrayList<Date>();
	private Statistiken stats;
	private Date daydate;
	private int index = 0;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public List<Integer> getEinnahmen(){
		return einnahmen;
	}
	public List<Date> getTage(){
		return tage;
	}
	
	public TagesEinnahmen(Parkhaus p) {
		this.p = p;
		stats = p.getStats();
		p.addChart(this);
		this.update();
		
		
		
	}
	
	@Override
	public void update() {
			stats = p.getStats();
			
			
			Iterator<String> si = new StatsIterator(stats,2);
			Iterator<String> sj = new StatsIterator(stats,4);
			
			while ( si.hasNext()) {
				daydate = new Date( Long.parseLong(si.next()));
				
				
				if (index == 0 & tage.size() ==0) {
					tage.add(daydate);
					
					einnahmen.add(Integer.parseInt(sj.next()));
					
					
				}else if(!(sdf.format(tage.get(index))).equals(sdf.format(daydate))) {
					
					tage.add(daydate);
					einnahmen.add(Integer.parseInt(sj.next()));
					index++;
					continue;
				}else {
				int einnahme = einnahmen.get(index);
				einnahme += Integer.parseInt(sj.next());
				einnahmen.set(index, einnahme);
				einnahme = 0;
				}
				
			}
					
			
	}

	@Override
	public String buildChart() {
		
		List<String> einString = einnahmen.stream().map(Object::toString)
                .collect(Collectors.toList());
		String[] einnahmenarr = new String[einString.size()];
		 einnahmenarr = einString.toArray(einnahmenarr);
		
		
		List<String> dayString = tage.stream().map(Object::toString)
                .collect(Collectors.toList());
		
		
		String[] days = new String[tage.size()];
		days= dayString.toArray(days);
		
		return BarChartBuilder.BuildBarChart(days, new String[][] {einnahmenarr}, new String[] {"Tageseinnahmen"});
		
	}

}
