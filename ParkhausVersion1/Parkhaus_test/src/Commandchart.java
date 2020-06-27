import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class Commandchart implements CommandIF {

	@Override
	public void execute(HttpServletResponse response, DemoServlet servlet) throws Exception {
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

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
