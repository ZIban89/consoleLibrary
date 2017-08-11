package by.htp.nikonov.task01.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import by.htp.nikonov.task01.controller.command.impl.AddEditBook;
import by.htp.nikonov.task01.controller.command.impl.AddNewBook;
import by.htp.nikonov.task01.controller.command.impl.DestroySource;
import by.htp.nikonov.task01.controller.command.impl.GetBookList;
import by.htp.nikonov.task01.controller.command.impl.InitializationSource;
import by.htp.nikonov.task01.controller.command.impl.SignIn;
import by.htp.nikonov.task01.controller.command.impl.SignUp;
import by.htp.nikonov.task01.controller.command.impl.WrongRequest;

public final class CommandProvider {
	//private static CommandProvider instance = null;
	private static final Logger log = Logger.getLogger(CommandProvider.class);
	private static final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		repository.put(CommandName.INITIALIZATION_SOURCE, new InitializationSource());
		repository.put(CommandName.DESTROY_SOURCE, new DestroySource());
		repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_UP, new SignUp());
		repository.put(CommandName.ADD_EDIT_BOOK, new AddEditBook());
		repository.put(CommandName.GET_BOOKLIST, new GetBookList());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	/*public static CommandProvider getInstance() {
		if(instance == null){
			instance = new CommandProvider();
		}
		return instance;
	}*/
	
	public Command getCommand(String key){
		Command command;
		CommandName commandName;
		
		try{
			commandName = CommandName.valueOf(key.toUpperCase());
			command = repository.get(commandName);			
		}catch (IllegalArgumentException | NullPointerException e) {
			log.error(e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
	}
	
}
