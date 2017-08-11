package by.htp.nikonov.task01.service.impl;

import org.junit.Test;

import by.htp.nikonov.task01.service.UserService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class TestUserServiceImpl {
/*	Зарегистрировать пользователя не получиться, т.к. мы не инициализировали ConnectionPool
 	Соответственно когда берем Connection получаем NullPointerException (ИСПРАВЛЕНО НА ServiceException).
*/
	@Test (expected = ServiceException.class)
	public void signUp() throws ServiceException{
		ServiceFactory factory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance(); ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		userService.signUp("Dylan O'Brien", "12345678");
	}
}
