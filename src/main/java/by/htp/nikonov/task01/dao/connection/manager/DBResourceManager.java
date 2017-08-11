package by.htp.nikonov.task01.dao.connection.manager;

import java.util.ResourceBundle;

public final class DBResourceManager {
	
	private final ResourceBundle bundle = ResourceBundle.getBundle("database");
	
	private DBResourceManager() {}

	
	public String getValue(String key){
		return bundle.getString(key);
	}
	
}
