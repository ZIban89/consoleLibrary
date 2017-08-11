package by.htp.nikonov.task01.dao.factory;

import by.htp.nikonov.task01.dao.BookDAO;
import by.htp.nikonov.task01.dao.InitializationDAO;
import by.htp.nikonov.task01.dao.UserDAO;


public final class DAOFactory {
	
	private final UserDAO userDAO;
	private final BookDAO bookDAO;
	private final InitializationDAO initializationDAO;
	
	private DAOFactory(UserDAO userDAO, BookDAO bookDAO, InitializationDAO initializationDAO ) {
		this.userDAO=userDAO;
		this.bookDAO=bookDAO;
		this.initializationDAO=initializationDAO;
	}

	

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public InitializationDAO getInitializationDAO() {
		return initializationDAO;
	}
	
}
