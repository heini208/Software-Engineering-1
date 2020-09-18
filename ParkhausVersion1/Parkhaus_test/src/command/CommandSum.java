package command;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class CommandSum implements CommandIF {

	
	public void execute(HttpServletResponse response,ParkhausServlet servlet) throws Exception {
		
		Float sum = servlet.getPersistentSum();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( sum );
		System.out.println( "sum = " + sum );
		
	}


	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
