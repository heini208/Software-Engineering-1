

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DemoServlet() {
   
    }
    
    private ServletContext getApplication(){
    	return getServletConfig().getServletContext();
    	}
    
    private Float getPersistentSum(){
    	 Float sum;
    	 ServletContext application = getApplication();
    	 sum = (Float)application.getAttribute("sum");
    	if ( sum == null ) sum = 0.0f;
    	return sum;
    	}
    private Float getAverage() {
    	Float avg;
    	ServletContext application = getApplication();
    	avg= (Float)application.getAttribute("avg");
    	if(avg == null) avg = 0.0f;
    	return avg;
    }
    private Integer getCount() {
    	Integer count;
    	ServletContext application = getApplication();
    	count = (Integer) application.getAttribute("count");
    	if(count == null) count = 0;
    	return count;
    }
    
   
    
    private Float getTAverage() {
    	Float tavg;
    	ServletContext application = getApplication();
    	tavg= (Float)application.getAttribute("tavg");
    	if(tavg == null) tavg = 0.0f;
    	return tavg;
    }
    private Float getTimeTotal() {
    	Float tsum;
    	ServletContext application = getApplication();
    	tsum= (Float)application.getAttribute("tsum");
    	if(tsum == null) tsum = 0.0f;
    	return tsum;
    }
    
    private List<CarIF> cars(String[] params){
    	ServletContext application = getApplication();
    	List<CarIF> cars = (ArrayList<CarIF>)application.getAttribute("cars");
    	if ( cars== null ) {
    	cars =new ArrayList<CarIF>();
    	}
    	
    	String ticket = params[5];
    	Iterator<CarIF> i = cars.listIterator();
    	while(i.hasNext()) {
    		if((i.next().getTicket()).equals(ticket)) {
    			i.remove();
    		}
    		
    	}
    	
    	
    	
    	cars.add(new Car(params));
    	
    	getApplication().setAttribute("cars", cars );
    	return cars;
    }
    
    private List<CarIF> getCars(){
    	ServletContext application = getApplication();
    	return  (List<CarIF>)application.getAttribute("cars");
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
		if ( "cmd".equals( command ) && "sum".equals( param ) ){
			
			// hier ist die summe
		 Float sum = getPersistentSum();
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println( sum );
		 System.out.println( "sum = " + sum );
		 } 
		else if ( "cmd".equals( command ) && "avg".equals( param ) ){
			
			
			Float avg = getAverage();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( avg );
			System.out.println( "avg = " + avg );
		 	} 
		else if ( "cmd".equals( command ) && "tavg".equals( param ) ){
			
			
			Float tavg = getTAverage();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( tavg );
			System.out.println( "tavg = " + tavg );
		 	} 
		else if ( "cmd".equals( command ) && "count".equals( param ) ){
			
			
			Integer count = getCount();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( count );
			System.out.println( "count = " + count );
		 	}
		else if ( "cmd".equals( command ) && "chart".equals( param ) ){
			
			if ( getCars()!= null) {
			
			
			String carnums = "\"Car_" + getCars().get(0).getcarnum()+"\"";
			String carvalues = ""+(getCars().get(0).getDuration())/1000;
			Iterator<CarIF> iterator = getCars().listIterator(1);
			
			while(iterator.hasNext()){
	    		CarIF c = iterator.next();
	    		System.out.println(carnums);
	    		
	    		carnums += ",\"Car_" + c.getcarnum()+"\"";
	    		carvalues += ","+ c.getDuration()/1000;
	    	}
	    	
			
			String root = "{\"data\":[{\"x\":["+ carnums +"],\"y\":["+carvalues+"],\"type\":\"bar\"}]}";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(root);
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
			
		}
		
		if( event.equals("leave") ){
		System.out.println(cars(params).toString());
		
		
			 
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
