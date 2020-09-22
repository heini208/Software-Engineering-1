/**
 * @author 
 * interface Klasse für Command
 */

package interfaceklassen;

import javax.servlet.http.HttpServletResponse;

import grundklassen.ParkhausServlet;

public interface CommandIF {

	public void execute(HttpServletResponse response,ParkhausServlet servlet)throws Exception;
	public void unexecute();
	
}
