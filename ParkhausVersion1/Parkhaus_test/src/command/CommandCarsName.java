/**
 * @author 
 * Der Command Commandavg wird zur durchschnitts berechnung verwendet
 * Methode execute || Berechnet den Durchschnitt
 * Methode unexecute || Stellt den Vorherigen wert wieder her
 */

package command;
import java.util.List;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import grundklassen.Car;
import grundklassen.ParkhausServlet;
import interfaceklassen.CarIF;
import interfaceklassen.CommandIF;
import interfaceklassen.ControllerIF;

public class CommandCarsName implements CommandIF{

	//execute || Berechnet den Durchschnitt
	@Override
	public void execute(HttpServletResponse response, ParkhausServlet servlet) throws Exception {
		ControllerIF controller = servlet.getParkhausController();
		List<String[]> leftCars = new ArrayList<String[]>();
		String data = "";
		String[] currentCar;
	//Autos im Parkhaus
		List<CarIF> cars = controller.getListOfCars();
	//Autos die im Parkhaus waren
		leftCars =  controller.getParkhausFromController().getStats().getStatistik();
	//Reiter entfernen
		
		String[] reiter = controller.getParkhausFromController().getStats().getReiter();
		leftCars.remove(reiter);
		
	// Autos im Parkhaus formatieren
		for (CarIF c : cars) {
			currentCar = c.carToString();
			data += currentCar[0] + "/";
				data += currentCar[1] + "/_/_/";
			
			data += currentCar[6] + "/" + currentCar[9] + "/" + currentCar[5] + "/"
					+currentCar[7] + "/" + currentCar[8] + "/"+ currentCar[0] + ",";
		}
		//Autos die im Parkhaus waren formatieren
		if (leftCars != null && !leftCars.isEmpty()) {
		for (String[] s : leftCars) {
			data += s[0] + "/";
				
				double duration = Double.parseDouble(s[3])*1000;
				double paid = Double.parseDouble(s[4])*100;
				data += s[2] + "/" +duration + "/"+paid+ "/"
						+ s[5] + "/" + s[9] + "/" + s[6] + "/"
						+s[7] + "/" + s[8] + "/"+ s[0] + ",";
		}
		}
		
		// letztes komma löschen
		data = Optional.ofNullable(data)
        .map(s -> s.replaceAll(".$", ""))
        .orElse(data);
		
		
		//Data Beispiel: "163/1600958591646/_/_/4e4a47a62cfae04e9725ca44fa0994bc/#2a7dab/96/Frau/Motorrad/124"
		response.setContentType("text/csv");
		PrintWriter out = response.getWriter();
		out.println( data );
	
		
	}

	//unexecute || Stellt den Vorherigen wert wieder her
	@Override
	public void unexecute() {
	
		
	}

}
