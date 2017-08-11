package by.htp.nikonov.task01.dao.impl;

import java.io.IOException;

import by.htp.nikonov.task01.dao.InitializationDAO;
import by.htp.nikonov.task01.dao.connection.ConnectionPool;
import by.htp.nikonov.task01.dao.exception.ConnectionPoolException;
import by.htp.nikonov.task01.dao.exception.DAOException;

public class InitializationDAOImpl implements InitializationDAO {

	@Override
	public void initialization() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		try {
			connectionPool.init();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem initialization database", e);
		}
	}

	@Override
	public void destroy() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		try {
			connectionPool.close();
		} catch (IOException e) {
			throw new DAOException("Failure to close all connections", e);
		}
	}

}
