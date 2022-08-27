package by.grovs.controller.command.impl;

import by.grovs.controller.command.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final CommandFactory INSTANCE = new CommandFactory();

    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("book", new BookCommand());
        commandMap.put("books", new BooksCommand());
        commandMap.put("users", new UsersCommand());
        commandMap.put("user", new UserCommand());
    }

    public Command getCommand(String command) {

        return commandMap.get(command);
    }


}
