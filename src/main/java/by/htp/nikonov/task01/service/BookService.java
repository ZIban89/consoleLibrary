package by.htp.nikonov.task01.service;

import java.util.List;

import by.htp.nikonov.task01.entity.Book;
import by.htp.nikonov.task01.service.exception.ServiceException;

public interface BookService {
	void addNewBook(String title, String genre, String author, String year, String quantity) throws ServiceException;
	void addEditBook(String title, String genre, String author, String year, String quantity, String idBook) throws ServiceException;
	List<Book> getBooklist() throws ServiceException;
}
