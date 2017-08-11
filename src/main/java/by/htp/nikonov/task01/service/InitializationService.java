package by.htp.nikonov.task01.service;

import by.htp.nikonov.task01.service.exception.ServiceException;

public interface InitializationService {
	void initialization() throws ServiceException;
	void destroy() throws ServiceException;
}
