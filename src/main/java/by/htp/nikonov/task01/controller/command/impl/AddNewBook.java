package by.htp.nikonov.task01.controller.command.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.BookRequestIndex;
import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.service.BookService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class AddNewBook implements Command {
	
	private static final Logger log = Logger.getLogger(AddNewBook.class);
	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(" ");
		String title = parameter[BookRequestIndex.TITLE_INDEX.getIndex()];
		String author = parameter[BookRequestIndex.AUTOR_INDEX.getIndex()];
		String genre = parameter[BookRequestIndex.GENRE_INDEX.getIndex()];
		String year = parameter[BookRequestIndex.YEAR_INDEX.getIndex()];
		String quantity = parameter[BookRequestIndex.QUANTITY_INDEX.getIndex()];
		
		ServiceFactory serviceFactory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		String response = null;
		
		try {
			bookService.addNewBook(title, genre, author, year, quantity);
			response = "Book successfully added";
		} catch (ServiceException e) {
			response = "Error adding book";
			log.log(Level.ERROR, e);
		}
		
		return response;
	}

}
