package Command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import GrundKlassen.DemoServlet;
import Interface.CommandIF;

public class Commandavg implements CommandIF{

	@Override
	public void execute(HttpServletResponse response, DemoServlet servlet) throws Exception {

		Float avg = servlet.getAverage();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( avg );
		System.out.println( "avg = " + avg );
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
