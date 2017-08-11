package by.htp.nikonov.task01.controller;

import by.htp.nikonov.task01.controller.command.Command;
import by.htp.nikonov.task01.controller.command.CommandProvider;
import by.htp.nikonov.task01.tools.ApplicationContextTool;

public final class Controller {
	private final char paramDelimeter = ' ';

	public String executeAction(String request) {
		String commandName;
		Command command;

		commandName = request.substring(0, request.indexOf(paramDelimeter));
		CommandProvider provider = ApplicationContextTool.getContext().getBean("commandProvider",
				CommandProvider.class);// CommandProvider.getInstance();
		command = provider.getCommand(commandName);

		String response = command.executeCommand(request);

		return response;
	}
}
