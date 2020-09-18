package Command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import GrundKlassen.DemoServlet;
import Interface.CommandIF;

public class Commandcount implements CommandIF {

	@Override
	public void execute(HttpServletResponse response, DemoServlet servlet) throws Exception {
		
		
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
