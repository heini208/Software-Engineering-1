/**
 * @author 
 * Der Command CommandAufruferClearall setzt das Parkhaus zur�ck
 * Methode compute || F�hrt den Reset durch 
 * Methode undo || setzt die werte zur�ck 
 */


package command;
import java.util.ArrayList;

import grundklassen.Parkhaus;
import interfaceklassen.CommandIF;

public class CommandAufruferClearall {

	//Klassenvariablen
	private Parkhaus parkhaus = new Parkhaus();
	private ArrayList<CommandIF> commands = new ArrayList<CommandIF>();
	private int current = 0;

	//undo || setzt die werte zur�ck 
	public void undo(int levels){
		System.out.println("\n---- Undo " + levels + " levels ");
		for(int i = 0; i< levels ;i++) {
			if(current>=0) {
				CommandIF command = commands.get(--current);
				command.unexecute();
			}
		}
	}
	
	//compute || F�hrt den Reset durch 
	public void compute(Parkhaus parkhausnew){
		
		CommandIF command = new CommandClearall(parkhausnew.clearall());
		//command.execute();
		
		commands.add(command);
		current++;
	}
}
