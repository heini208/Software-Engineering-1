import java.util.ArrayList;

public class CommandAufruferClearall {

	private Parkhaus parkhaus = new Parkhaus();
	private ArrayList<CommandIF> commands = new ArrayList<CommandIF>();
	
	private int current = 0;

	public void undo(int levels){
		System.out.println("\n---- Undo " + levels + " levels ");
		for(int i = 0; i< levels ;i++) {
			if(current>=0) {
				CommandIF command = commands.get(--current);
				command.unexecute();
			}
		}
	}
	
	public void compute(Parkhaus parkhausnew){
		
		CommandIF command = new CommandClearall(parkhausnew.clearall());
		command.execute();
		
		commands.add(command);
		current++;
	}
}
