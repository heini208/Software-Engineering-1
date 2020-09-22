/**
 * @author 
 * Der Command Commandchart gibt die Diagramme aus und sendet sie an das Servlet
 * Methode execute || Sendet die Charts an das Servlet 
 * Methode unexecute || Stellt das vorherige Diagramm wieder her
 */

package command;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import charts.PaidDurationChart;
import grundklassen.ParkhausServlet;
import interfaceklassen.ChartIF;
import interfaceklassen.CommandIF;

public class Commandchart implements CommandIF {

	//execute || Sendet die Charts an das Servlet 
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		String ausgabe = "";
		if ( servlet.getParkhaus()!= null) {
			List<ChartIF> charts = servlet.getCharts();
			for ( ChartIF chart : charts) {
				if (chart instanceof PaidDurationChart) {
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
		// TODO Auto-generated method stub
		
	}

}
