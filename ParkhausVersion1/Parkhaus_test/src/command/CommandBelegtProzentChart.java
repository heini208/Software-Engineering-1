/**
 * @author 
 * Der Command CommandBelegtProzentChart gibt die Diagramme aus und sendet sie an das Servlet
 * Methode execute || Sendet die Charts an das Servlet 
 * Methode unexecute || Stellt das vorherige Diagramm wieder her
 */

package command;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import charts.BelegtProzentChart;
import grundklassen.ParkhausServlet;
import interfaceklassen.ChartIF;
import interfaceklassen.CommandIF;

public class CommandBelegtProzentChart implements CommandIF {

	//execute || Sendet die Charts an das Servlet 
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		String ausgabe = "";
		if ( servlet.getParkhausController()!= null) {
			List<ChartIF> charts = servlet.getCharts();
			for ( ChartIF chart : charts) {
				if (chart instanceof BelegtProzentChart) {
					ausgabe = chart.buildChart();
				}
			}
			System.out.println(ausgabe);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(ausgabe);

		}
		
	}

	//unexecute || Stellt das vorherige Diagramm wieder her
	@Override
	public void unexecute() {
		
		
	}

}
