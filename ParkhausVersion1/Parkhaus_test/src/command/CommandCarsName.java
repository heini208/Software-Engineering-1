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

public class CommandCarsName implements CommandIF{

	//execute || Berechnet den Durchschnitt
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {

		String data = "163/1600958591646/_/_/4e4a47a62cfae04e9725ca44fa0994bc/#2a7dab/96/Frau/Motorrad/124";
		response.setContentType("text/csv");
		PrintWriter out = response.getWriter();
		out.println( data );
	
		
	}

	//unexecute || Stellt den Vorherigen wert wieder her
	@Override
	public void unexecute() {
	
		
	}

}
