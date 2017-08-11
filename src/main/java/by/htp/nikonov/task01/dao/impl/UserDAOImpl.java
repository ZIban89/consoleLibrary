package by.htp.nikonov.task01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.nikonov.task01.dao.ColumnLabel;
import by.htp.nikonov.task01.dao.SQLCommand;
import by.htp.nikonov.task01.dao.UserDAO;
import by.htp.nikonov.task01.dao.connection.ConnectionPool;
import by.htp.nikonov.task01.dao.exception.ConnectionPoolException;
import by.htp.nikonov.task01.dao.exception.DAOException;
import by.htp.nikonov.task01.entity.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public User signIn(String login, int password) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(ColumnLabel.USER_ID));
				user.setLogin(resultSet.getString(ColumnLabel.USER_LOGIN));
				user.setPassword(resultSet.getInt(ColumnLabel.USER_PASSWORD));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_id_by_login_password'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return user;
	
	}

	@Override
	public void signUp(String login, int password) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_USER);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password);		
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'insert_user'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
	}

}
