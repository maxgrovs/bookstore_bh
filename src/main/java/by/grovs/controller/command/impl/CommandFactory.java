package by.grovs.controller;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static final CommandFactory INSTANCE = new CommandFactory();

    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("book", new BookCommand());
        commandMap.put("books", new BooksCommand());
    }

    public Command getCommand(String command) {

        return commandMap.get(command);
    }


}
