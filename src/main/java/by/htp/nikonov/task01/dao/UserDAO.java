package by.htp.nikonov.task01.dao;

import by.htp.nikonov.task01.dao.exception.DAOException;
import by.htp.nikonov.task01.entity.User;

public interface UserDAO {
	User signIn(String login, int password) throws DAOException;
	void signUp(String login, int password) throws DAOException;
}
