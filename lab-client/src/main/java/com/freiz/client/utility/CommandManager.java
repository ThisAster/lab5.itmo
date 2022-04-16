package com.freiz.client.utility;

import com.freiz.client.commands.*;

import java.util.HashSet;

public class CommandManager {
    private final HashSet<Command> commands = new HashSet<>();

    public CommandManager(FileManager fileManager, UserInputManager userInputManager,
                          CollectionManager collectionManager, OutputManager outputManager,
                          HistoryManager historyManager) {
        commands.add(new HelpCommand());
        commands.add(new AddElem(userInputManager, outputManager, collectionManager));
        commands.add(new AddIfMinCommand(collectionManager, userInputManager, outputManager));
        commands.add(new AddIfMaxCommand(collectionManager, userInputManager, outputManager));
        commands.add(new ClearCommand(collectionManager));
        commands.add(new SaveCommand(fileManager, collectionManager));
        commands.add(new ShowCommand(collectionManager));
        commands.add(new UpdateCommand(collectionManager, userInputManager, outputManager));
        commands.add(new CountGreaterThanHeartCountCommand(collectionManager));
        commands.add(new CountLessThanMeleeWeaponMeleeWeaponCommand(collectionManager));
        commands.add(new ExitCommand());
        commands.add(new InfoCommand(collectionManager));
        commands.add(new FilterByWeaponTypeCommand(collectionManager));
        commands.add(new HistoryCommand(historyManager));
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new RemoveByIdCommand(collectionManager));
    }

    public HashSet<Command> getCommands() {
        return commands;
    }
}
