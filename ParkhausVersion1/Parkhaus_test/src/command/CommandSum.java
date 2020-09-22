/**
 * @author 
 * Der Command CommandSum gibt die Summe der Autos aus und sendet sie an das Servlet
 * Methode execute || sendet die Summe der Autos an das servlet 
 * Methode unexecute || Stellt die vorherige Summe der Autos wieder her
 */

package command;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class CommandSum implements CommandIF {

	//execute || sendet die Summe der Autos an das servlet 
	public void execute(HttpServletResponse response,ParkhausServlet servlet) throws Exception {
		
		Float sum = servlet.getPersistentSum();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( sum );
		System.out.println( "sum = " + sum );
		
	}

	
	//unexecute || Stellt die vorherige Summe der Autos wieder her
	public void unexecute() {
		
		
	}

}
