package by.htp.nikonov.task01.view;

import by.htp.nikonov.task01.controller.Controller;

public final class View {
	private static final Controller CONTROLLER = new Controller();
	public static void main(String [] args){
		String response = null;
		
//		##Initialization DB connection##
		response = CONTROLLER.executeAction("initialization_source ");
		PrintResponse.out(response);
		
		
//		##Sign up user
	response = CONTROLLER.executeAction("sign_up Василий_Пупкин 12345678");
		PrintResponse.out(response);

		
// 		##Sign in user
		response = CONTROLLER.executeAction("sign_in Василий_Пупкин 12345678");
		PrintResponse.out(response);
		

// 		##Add new book
//		Example: add_new_book Title Genre Author Year Quantity
		response = CONTROLLER.executeAction("add_new_book MyBook Action Vasya_Pupkin 2017 2");
		PrintResponse.out(response);

		
// 		##Add edit book
//		Example: add_edit_book Title Genre Author Year Quantity idBook
		response = CONTROLLER.executeAction("add_edit_book MyBook Action Petya_Pupkin 2017 2 15");
		PrintResponse.out(response);

		
//		##Get booklist
		CONTROLLER.executeAction("get_booklist ");
		PrintResponse.out(response);

		
// 		##Remove book
//		Example: remove_book idBook
		response = CONTROLLER.executeAction("remove_book 1");
		PrintResponse.out(response);
		
		
//		##Destroy DB connection##
		response = CONTROLLER.executeAction("destroy_source ");
		PrintResponse.out(response);
	}
}
