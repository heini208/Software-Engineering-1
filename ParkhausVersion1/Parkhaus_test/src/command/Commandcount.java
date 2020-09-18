package command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class Commandcount implements CommandIF {

	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		
		
		Integer count = servlet.getCount();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( count );
		System.out.println( "count = " + count );
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
