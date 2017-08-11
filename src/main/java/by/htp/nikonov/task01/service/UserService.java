package by.htp.nikonov.task01.service;

import by.htp.nikonov.task01.service.exception.ServiceException;

public interface UserService {
	void signIn(String login, String password) throws ServiceException;
	void signUp(String login, String password) throws ServiceException;
}
