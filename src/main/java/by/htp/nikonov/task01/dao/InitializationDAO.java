package by.htp.nikonov.task01.dao;

import by.htp.nikonov.task01.dao.exception.DAOException;

public interface InitializationDAO {
	void initialization() throws DAOException;
	void destroy() throws DAOException;
}
