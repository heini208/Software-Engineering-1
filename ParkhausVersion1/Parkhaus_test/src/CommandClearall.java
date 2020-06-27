
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

	
}
