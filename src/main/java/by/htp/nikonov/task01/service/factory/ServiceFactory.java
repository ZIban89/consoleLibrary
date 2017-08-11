package by.htp.nikonov.task01.service.factory;


import by.htp.nikonov.task01.service.BookService;
import by.htp.nikonov.task01.service.InitializationService;
import by.htp.nikonov.task01.service.UserService;


public final class ServiceFactory {
	
	private final UserService userService;
	private final BookService bookService;
	private final InitializationService initializationService;
	
	private ServiceFactory(UserService userService, BookService bookService, InitializationService initializationService) {
		this.userService=userService;
		this.bookService=bookService;
		this.initializationService=initializationService;
	}

	

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public InitializationService getInitializationService() {
		return initializationService;
	}
	
}
