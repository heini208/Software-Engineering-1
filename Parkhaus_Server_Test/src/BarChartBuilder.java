import java.util.Arrays;

import org.json.*;


public class BarChartBuilder {




	public static String BuildBarChart (String[] x , String[][] y , String[] names) {

		//TODO Default name einfügen statt Trace1 .
		String[] names1  = Arrays.copyOf(names, y.length);
		JSONObject root = new JSONObject ();
		JSONArray root2 = new JSONArray	() ;
		for(int i = 0; i<y.length; i++)	{
			root2.put(new JSONObject()
					.put("x",x)
					.put("y",y[i])
					.put("type", "bar")
					.put("name",names1[i]));
		}			


		root.put("data",root2 );

		return root.toString();
	}


}
