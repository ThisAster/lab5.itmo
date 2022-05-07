package com.freiz.client.utility;

import com.freiz.client.commands.AddCommand;
import com.freiz.client.commands.AddIfMaxCommand;
import com.freiz.client.commands.AddIfMinCommand;
import com.freiz.client.commands.ClearCommand;
import com.freiz.client.commands.Command;
import com.freiz.client.commands.CountGreaterThanHeartCountCommand;
import com.freiz.client.commands.CountLessThanMeleeWeaponMeleeWeaponCommand;
import com.freiz.client.commands.ExecuteScriptCommand;
import com.freiz.client.commands.ExitCommand;
import com.freiz.client.commands.FilterByWeaponTypeCommand;
import com.freiz.client.commands.HelpCommand;
import com.freiz.client.commands.HistoryCommand;
import com.freiz.client.commands.InfoCommand;
import com.freiz.client.commands.RemoveByIdCommand;
import com.freiz.client.commands.SaveCommand;
import com.freiz.client.commands.ShowCommand;
import com.freiz.client.commands.UpdateCommand;

import java.util.HashSet;

public class CommandManager {
    private final HashSet<Command> commands = new HashSet<>();

    public CommandManager(FileManager fileManager, UserInputManager userInputManager,
                          CollectionManager collectionManager, OutputManager outputManager,
                          HistoryManager historyManager) {
        commands.add(new HelpCommand());
        commands.add(new AddCommand(collectionManager, userInputManager, outputManager));
        commands.add(new AddIfMinCommand(collectionManager, userInputManager, outputManager));
        commands.add(new AddIfMaxCommand(collectionManager, userInputManager, outputManager));
        commands.add(new ClearCommand(collectionManager));
        commands.add(new SaveCommand(fileManager, collectionManager));
        commands.add(new ShowCommand(collectionManager));
        commands.add(new UpdateCommand(collectionManager, userInputManager, outputManager));
        commands.add(new CountGreaterThanHeartCountCommand(collectionManager));
        commands.add(new CountLessThanMeleeWeaponMeleeWeaponCommand());
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
