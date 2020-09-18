package interfaceklassen;

import javax.servlet.http.HttpServletResponse;

import grundklassen.DemoServlet;

public interface CommandIF {

	public void execute(HttpServletResponse response,DemoServlet servlet)throws Exception;
	public void unexecute();
	
}
