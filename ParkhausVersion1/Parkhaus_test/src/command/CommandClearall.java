package command;
import javax.servlet.http.HttpServletResponse;

import grundklassen.DemoServlet;
import grundklassen.Parkhaus;
import interfaceklassen.CommandIF;

public class CommandClearall implements CommandIF{

	Parkhaus parkhaus ;
	Parkhaus previousparkhaus;
	

	public CommandClearall (Parkhaus parkhaus) {
		this.previousparkhaus=parkhaus;
		this.parkhaus=parkhaus;
	}
	public void execute() {
		parkhaus.clearall();
	}

	
	public void unexecute() {
		this.parkhaus=previousparkhaus;
		
	}
	@Override
	public void execute(HttpServletResponse response, DemoServlet servlet) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
