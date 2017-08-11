package by.htp.nikonov.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.service.InitializationService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class InitializationSource implements Command {

	private static final Logger log = Logger.getLogger(InitializationSource.class);
	@Override
	public String executeCommand(String request) {
		ServiceFactory factory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
		InitializationService initializationService = factory.getInitializationService();
		String response = null;
		
		try {
			initializationService.initialization();
			response = "Database has been initialized";
		} catch (ServiceException e) {
			response = "Database has not been initialized";
			e.printStackTrace();
			log.error(e);	
		}
		
		return response;
	}

}
