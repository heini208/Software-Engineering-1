package Interface;

import javax.servlet.http.HttpServletResponse;

import GrundKlassen.DemoServlet;

public interface CommandIF {

	public void execute(HttpServletResponse response,DemoServlet servlet)throws Exception;
	public void unexecute();
	
}
