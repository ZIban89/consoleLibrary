package by.htp.nikonov.task01.controller.command;

public enum UserRequestIndex {
	LOGIN_INDEX(1),
	PASSWORD_INDEX(2);
	
	private UserRequestIndex(int id) {
		this.id=id;
	}
	private int id;
	
	public int getId() {
		return id;
	}
}
