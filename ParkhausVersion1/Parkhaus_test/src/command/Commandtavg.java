package command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import grundklassen.DemoServlet;
import interfaceklassen.CommandIF;

public class Commandtavg implements CommandIF {

	@Override
	public void execute(HttpServletResponse response, DemoServlet servlet) throws Exception {
		
		Float tavg = servlet.getTAverage();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( tavg );
		System.out.println( "tavg = " + tavg );
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
