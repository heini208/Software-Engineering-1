
import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,CommandIF> actionMap = new HashMap<String,CommandIF>();

	public DemoServlet() {
		actionMap.put("sum",new CommandSum());
		actionMap.put("avg",new Commandavg());
		actionMap.put("count",new Commandcount());
		actionMap.put("tavg",new Commandtavg());
		actionMap.put("chart",new Commandchart());
		actionMap.put("familiechart",new CommandFamilieChart());
		
	}

	protected ServletContext getApplication(){
		return getServletConfig().getServletContext();
	}

	protected Float getPersistentSum(){
		Float sum;
		ServletContext application = getApplication();
		sum = (Float)application.getAttribute("sum");
		if ( sum == null ) sum = 0.0f;
		return sum;
	}
	protected Float getAverage() {
		Float avg;
		ServletContext application = getApplication();
		avg= (Float)application.getAttribute("avg");
		if(avg == null) avg = 0.0f;
		return avg;
	}
	protected Integer getCount() {
		Integer count;
		ServletContext application = getApplication();
		count = (Integer) application.getAttribute("count");
		if(count == null) count = 0;
		return count;
	}

	


	protected Float getTAverage() {
		Float tavg;
		ServletContext application = getApplication();
		tavg= (Float)application.getAttribute("tavg");
		if(tavg == null) tavg = 0.0f;
		return tavg;
	}
	protected Float getTimeTotal() {
		Float tsum;
		ServletContext application = getApplication();
		tsum= (Float)application.getAttribute("tsum");
		if(tsum == null) tsum = 0.0f;
		return tsum;
	}
	
	protected List<ChartIF> getCharts(){
		ServletContext application = getApplication();
		List<ChartIF> charts = ((ControllerIF) application.getAttribute("controllerParkhausViews")).getParkhaus().getChart();
		if (charts == null) {
			
			charts = new ArrayList<ChartIF>();
		}
		return charts;
		
	}

	// returns Parkhaus saved in ServletContext
	protected ControllerIF getParkhaus(){
		ServletContext application = getApplication();
		ControllerIF controllerParkhaus =  (ControllerIF)application.getAttribute("controllerParkhausViews");
		if(controllerParkhaus == null) {
			controllerParkhaus = new ControllerParkhausViews();
			
		}
		return controllerParkhaus;
	}


	private static String getBody(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return stringBuilder.toString();
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String[] requestParamString = request.getQueryString().split("=");
		String command = requestParamString[0];
		String param = requestParamString[1];
		
		
		if(actionMap.containsKey(param)) {
			CommandIF command1 = actionMap.get(param);
			try {
				command1.execute(response, this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println( "Invalid Command: " + request.getQueryString() );
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String body = getBody( request );
		System.out.println( body );
		String[] params = body.split(",");
		String event = params[0];
		if( event.equals("enter") ){
			ControllerIF controllerParkhaus = getParkhaus();
			int space = controllerParkhaus.enter(params);
			//Parkplatz ändern ->
			response.getOutputStream().println(space);
			getApplication().setAttribute("controllerParkhausViews", controllerParkhaus);
		}

		if( event.equals("leave") ){
			
			ControllerIF controllerParkhaus = getParkhaus();
			try {
				controllerParkhaus.leave(params);
			} catch (Exception e) {
				System.out.println(e);
			}
			getApplication().setAttribute("controllerParkhausViews", controllerParkhaus);
			

			Float avg = getAverage();
			Float tavg = getTAverage();
			Float tsum = getTimeTotal();

			Integer count = getCount();
			count++;

			Float sum = getPersistentSum(); 
			String priceString = params[4];
			String timeString = params[3];


			if ( ! "_".equals( priceString ) ){
				// parse the number in string
				float price = Float.parseFloat( priceString );
				float time = Float.parseFloat(timeString);

				tsum += time/1000;
				tavg = tsum/count;


				sum += price/100;
				avg = sum/count;
				// store sum persistently in ServletContext
			
				getApplication().setAttribute("sum", sum );
				getApplication().setAttribute("count", count );
				getApplication().setAttribute("avg", avg );
				getApplication().setAttribute("tavg", tavg );
				getApplication().setAttribute("tsum", tsum );
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( sum );
		}
	}

	
}
