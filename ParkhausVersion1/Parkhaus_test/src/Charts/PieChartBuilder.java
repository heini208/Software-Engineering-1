package Charts;
import org.json.*;

public class PieChartBuilder {

	public static String BuildPieChart(String[] x , int[] y ) {
			int[] values = y;	
			String[] labels =x;
			String type = "pie";
			
		JSONObject root = new JSONObject ();
		JSONArray root2 = new JSONArray	() ;
		
		root2.put( new JSONObject()
				.put("values",values)
				.put("labels",labels)
				.put("type", "pie"));
		
		root.put("data",root2 );
		
		return root.toString();
	}
}
