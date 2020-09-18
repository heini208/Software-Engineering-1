package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCommand {
	private Map<String,CommandSumTestHelperClass> actionMap = new HashMap<String,CommandSumTestHelperClass>();

	@BeforeEach
	void set(){
		
		actionMap.put("avg",new CommandSumTestHelperClass());
		
	}
	
	@Test
	void test() {
		String param = "avg";
		String response ="response";
		if(actionMap.containsKey(param)) {
			CommandSumTestHelperClass command1 = actionMap.get(param);
			try {
				assertEquals("This is Correct",command1.execute(response, param));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	
	
	class CommandSumTestHelperClass{

		public String execute(String response, String servlet) throws Exception {
			
			return "This is Correct";
		}

		public void unexecute() {
			
		}
		
	}
}
