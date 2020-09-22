/**
 * @author 
 * Der Command Commandtavg gibt die Durchschnittliche Summe der Autos aus und sendet sie an das Servlet
 * Methode execute || sendet die Durchschnittliche Summe der Autos an das servlet 
 * Methode unexecute || Stellt die vorherige Durchschnittliche Summe der Autos wieder her
 */

package command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class Commandtavg implements CommandIF {

	//execute || sendet die Durchschnittliche Summe der Autos an das servlet 
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		
		Float tavg = servlet.getTAverage();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( tavg );
		System.out.println( "tavg = " + tavg );
		
	}

	//unexecute || Stellt die vorherige Durchschnittliche Summe der Autos wieder her
	@Override
	public void unexecute() {
		
		
	}

}
