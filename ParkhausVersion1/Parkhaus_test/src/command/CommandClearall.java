/**
 * @author 
 * Der Command CommandClearall Löscht das Parkhaus 
 * Methode execute || Löscht das Parkhaus 
 * Methode unexecute || Stellt das vorherige Parkhaus wieder her
 * Methode CommandClearall || Löscht das Parkhaus und generiert ein neues Leeres Parkhaus
 */

package command;
import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;
import grundklassen.Parkhaus;
import interfaceklassen.CommandIF;

public class CommandClearall implements CommandIF{

	//Klassenvariablen 
	private Parkhaus parkhaus ;
	private Parkhaus previousparkhaus;
	

	//CommandClearall || Löscht das Parkhaus und generiert ein neues Leeres Parkhaus
	public CommandClearall (Parkhaus parkhaus) {
		this.previousparkhaus=parkhaus;
		this.parkhaus=parkhaus;
	}
	
	//execute || Löscht das Parkhaus 
	public void execute() {
		parkhaus.clearall();
	}
	
	//execute || Löscht das Parkhaus 
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		parkhaus.clearall();
	}
	
	//unexecute || Stellt das vorherige Parkhaus wieder her
	public void unexecute() {
		this.parkhaus=previousparkhaus;
		
	}
	
	
	

	
}
