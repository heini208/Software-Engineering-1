/**
 * @author 
 * Der Command Commandcount gibt die diagramme aus und sendet sie an das Servlet
 * Methode execute || sendet die diagramme an das servlet 
 * Methode unexecute || Stellt die vorherigen diagramme wieder her
 */

package command;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import charts.TypeCountPieChart;
import grundklassen.ParkhausServlet;
import interfaceklassen.ChartIF;
import interfaceklassen.CommandIF;

public class CommandFamilieChart implements CommandIF{

	//execute || sendet die diagramme an das servlet 
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		
		// Frau , Familie , Behindert , Any 
		
		
		String ausgabe = "";
		if ( servlet.getParkhaus()!= null) {
			List<ChartIF> charts = servlet.getCharts();
			for ( ChartIF chart : charts) {
				if (chart instanceof TypeCountPieChart) {
					ausgabe = chart.buildChart();
				}
			}
			System.out.println(ausgabe);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(ausgabe);

		}
		
	}

	//unexecute || Stellt die vorherigen diagramme wieder her
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}
		
}

