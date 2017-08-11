package by.htp.nikonov.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.service.InitializationService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class DestroySource implements Command {

	private static final Logger log = Logger.getLogger(DestroySource.class);
	@Override
	public String executeCommand(String request) {
		ServiceFactory factory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
		InitializationService initializationService = factory.getInitializationService();
		String response = null;
		
		try {
			initializationService.destroy();
			response = "Database has been destroyed";
		} catch (ServiceException e) {
			log.error(e);	
		}
		
		return response;
	}

}
