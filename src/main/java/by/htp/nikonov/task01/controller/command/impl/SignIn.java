package by.htp.nikonov.task01.controller.command.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.controller.command.UserRequestIndex;
import by.htp.nikonov.task01.service.UserService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class SignIn implements Command {

	private static final Logger log = Logger.getLogger(SignIn.class);
	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(" ");
		String login = parameter[UserRequestIndex.LOGIN_INDEX.getId()];
		String password = parameter[UserRequestIndex.PASSWORD_INDEX.getId()];
		
		ServiceFactory serviceFactory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		String response = null;
		
		try {
			userService.signIn(login, password);
			response = "Welcome " + login;
		} catch (ServiceException e) { 
			response = "Sign in error";
			log.log(Level.ERROR, e);
		}
		
		return response;
	}

}
