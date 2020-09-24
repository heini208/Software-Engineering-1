/**
 * @author 
 * Der Command Commandavg wird zur durchschnitts berechnung verwendet
 * Methode execute || Berechnet den Durchschnitt
 * Methode unexecute || Stellt den Vorherigen wert wieder her
 */

package command;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import interfaceklassen.CommandIF;

public class Commandnextday implements CommandIF{

	//execute || Berechnet den Durchschnitt
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {

		long nextday = servlet.getNextDay();
		
		//86400000 = 1 Tag 
		 
		nextday+=86400000;
		
		/**
		 * LocalTime LocalTime = java.time.LocalTime.now(ZoneId.of("Europe/Berlin"));
		 * LocalTime.plusHours(24);
		 */
		servlet.setNextDay(nextday);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( nextday );
		System.out.println( "Tage + = "+nextday/86400000 );
		
		
		
		
	}

	//unexecute || Stellt den Vorherigen wert wieder her
	@Override
	public void unexecute() {
	
		
	}

}
