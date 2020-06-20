import org.json.*;

public class BarChartBuilder {

	//Barcharts
	
	
	public static String BuildBarChart (String[] x , String[][] y , String[] names) {

		JSONObject root = new JSONObject ();
			JSONArray root2 = new JSONArray	() ;
	
						for(int i = 0; i<y.length; i++)	{
							root2.put(new JSONObject()
									.put("x",x)
									.put("y",y[i])
									.put("type", "bar")
									.put("name",names[i]));
						}			
									
											
		root.put("data",root2 );

		return root.toString();
	}
}
