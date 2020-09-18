package grundklassen;
import java.util.Arrays;
import java.util.Iterator;

public class StatsIterator implements Iterator<String>{
	
	private String[] flatstats;
	private int index;
	private int size;

	
	
	public StatsIterator(Statistiken stats, int start) {
		flatstats = stats.getStatistik().stream().flatMap(Arrays::stream).toArray(String[]::new);
		size = flatstats.length;
		index = (start%9)+9;
	}

	@Override
	public String next() {
		String next = flatstats[index];
		index+= 9;
		return next;
	}

	@Override
	public boolean hasNext() {
		
		return index < size;
	}

}