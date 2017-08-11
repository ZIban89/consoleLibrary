package by.htp.nikonov.task01.service.impl;

import by.htp.nikonov.task01.dao.InitializationDAO;
import by.htp.nikonov.task01.dao.exception.DAOException;
import by.htp.nikonov.task01.dao.factory.DAOFactory;
import by.htp.nikonov.task01.service.InitializationService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class InitializationServiceImpl implements InitializationService {

	@Override
	public void initialization() throws ServiceException {
		DAOFactory factory =
				ApplicationContextTool.getContext().getBean("DAOFactory", DAOFactory.class);//DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		try {
			initializationDAO.initialization();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization",e);
		}
	}

	@Override
	public void destroy() throws ServiceException {
		DAOFactory factory =
				ApplicationContextTool.getContext().getBean("DAOFactory", DAOFactory.class);//DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		
		try {
			initializationDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroy",e);
		}
	}

}
