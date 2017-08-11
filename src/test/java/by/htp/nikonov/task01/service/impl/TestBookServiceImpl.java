package by.htp.nikonov.task01.service.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import by.htp.nikonov.task01.dao.connection.ConnectionPool;
import by.htp.nikonov.task01.dao.exception.ConnectionPoolException;
import by.htp.nikonov.task01.service.BookService;
import by.htp.nikonov.task01.service.exception.ServiceException;
import by.htp.nikonov.task01.service.factory.ServiceFactory;
import by.htp.nikonov.task01.tools.ApplicationContextTool;


public class TestBookServiceImpl {
	private final ServiceFactory factory = 
			ApplicationContextTool.getContext().getBean("serviceFactory", ServiceFactory.class);// ServiceFactory.getInstance();
	private final BookService bookService = factory.getBookService();
	
	@BeforeClass
	public static void initSource() throws ConnectionPoolException{
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.init();
	}

	@AfterClass
	public static void destroySource() throws ConnectionPoolException, IOException{
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.close();
	}
	
	
	@Test  (expected = ServiceException.class)
	public void testAddNewBook() throws ServiceException{ 
		bookService.addNewBook(null, null, null, null, null);
	}

	@Test
	public void testAddEditBook(){
		try {
			bookService.addEditBook(null, "MyAuthor", "MyGenre", "2017", "10", "1");
		} catch (ServiceException e) {
			Assert.assertEquals("Incorrect data about book", e.getMessage());
		}
	}
	
}
