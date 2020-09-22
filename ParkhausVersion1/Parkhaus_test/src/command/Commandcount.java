/**
 * @author 
 * Der Command Commandcount gibt die anzahl an autos aus und sendet sie an das Servlet
 * Methode execute || sendet die anzahl an autos an das servlet 
 * Methode unexecute || Stellt das vorherige anzahl der Autos wieder her
 */

package command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class Commandcount implements CommandIF {

	//execute || sendet die anzahl an autos an das servlet 
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		
		
		Integer count = servlet.getCount();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( count );
		System.out.println( "count = " + count );
		
	}

	//unexecute || Stellt das vorherige anzahl der Autos wieder her
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
