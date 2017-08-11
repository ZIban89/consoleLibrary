package by.htp.nikonov.task01.tools;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTool {
	private static ClassPathXmlApplicationContext context;
	public static ClassPathXmlApplicationContext getContext() {
		if(context==null)
			context= new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;

	}
	
	
}
