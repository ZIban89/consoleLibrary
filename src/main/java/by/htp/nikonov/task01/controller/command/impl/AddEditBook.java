package by.htp.nikonov.task01.controller.command.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.htp.nikonov.task01.controller.command.BookRequestIndex;
import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.service.BookService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public class AddEditBook implements Command {

	private static final Logger log = Logger.getLogger(AddEditBook.class);
	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(" ");
		String title = parameter[BookRequestIndex.TITLE_INDEX.getIndex()];
		String author = parameter[BookRequestIndex.AUTOR_INDEX.getIndex()];
		String genre = parameter[BookRequestIndex.GENRE_INDEX.getIndex()];
		String year = parameter[BookRequestIndex.YEAR_INDEX.getIndex()];
		String quantity = parameter[BookRequestIndex.QUANTITY_INDEX.getIndex()];
		String idBook = parameter[BookRequestIndex.ID_BOOK_INDEX.getIndex()];

		ServiceFactory serviceFactory = 
				ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);//ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		String response = null;
		
		try {
			bookService.addEditBook(title, genre, author, year, quantity, idBook);
			response = "Book successfully edited";
		} catch (ServiceException e) {
			response = "Error editing book";
			log.log(Level.ERROR, e);
		}
		
		return response;
	}

}
