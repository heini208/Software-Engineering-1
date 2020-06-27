
import javax.servlet.http.HttpServletResponse;

public interface CommandIF {

	public void execute(HttpServletResponse response,DemoServlet servlet)throws Exception;
	public void unexecute();
	
}
