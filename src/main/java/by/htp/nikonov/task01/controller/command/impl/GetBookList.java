package by.htp.nikonov.task01.controller.command.impl;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.entity.Book;
import by.htp.nikonov.task01.service.BookService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;
import by.htp.nikonov.task01.view.PrintResponse;

public class GetBookList implements Command {

	private static final Logger log = Logger.getLogger(GetBookList.class);
	@Override
	public String executeCommand(String request) {
		ServiceFactory serviceFactory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		
		List<Book> booklist = null;
		String response = null;
		try {
			booklist = bookService.getBooklist();
			response = "List of books received";
			
			//Circle just for test
			for(Book book: booklist){
				PrintResponse.out(book.toString());
			}
		} catch (ServiceException e) {
			response = "Error getting list of books";
			log.log(Level.ERROR, e);
		}
		
		return response;
	}

}
