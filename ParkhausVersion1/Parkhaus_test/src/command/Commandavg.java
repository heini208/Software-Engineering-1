/**
 * @author 
 * Der Command Commandavg wird zur durchschnitts berechnung verwendet
 * Methode execute || Berechnet den Durchschnitt
 * Methode unexecute || Stellt den Vorherigen wert wieder her
 */

package command;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class Commandavg implements CommandIF{

	//execute || Berechnet den Durchschnitt
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {

		Float avg = servlet.getAverage();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( avg );
		System.out.println( "avg = " + avg );
		
	}

	//unexecute || Stellt den Vorherigen wert wieder her
	@Override
	public void unexecute() {
	
		
	}

}
