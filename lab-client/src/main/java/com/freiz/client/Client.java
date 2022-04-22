package com.freiz.client;

import com.google.gson.JsonSyntaxException;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.FileManager;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.HistoryManager;
import com.freiz.client.utility.CommandManager;
import com.freiz.client.utility.CommandRunManager;
import com.freiz.client.utility.Console;

import java.io.IOException;
import java.util.NoSuchElementException;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {

        final OutputManager outputManager = new OutputManager();

        if (args.length == 0) {
            outputManager.println("This program needs a file in argument to work with.");
            return;
        }

        if (!args[0].endsWith(".json")) {
            outputManager.println("This program can only work with .json file.");
            return;
        }

        final HistoryManager historyManager = new HistoryManager();
        final CollectionManager collectionManager = new CollectionManager();
        final FileManager fileManager = new FileManager(args[0]);
        final UserInputManager userInputManager = new UserInputManager();
        final CommandManager commandManager = new CommandManager(fileManager, userInputManager, collectionManager, outputManager, historyManager);
        final CommandRunManager commandRunManager = new CommandRunManager(commandManager, historyManager);
        final Console console = new Console(fileManager,
                userInputManager, collectionManager, outputManager,
                commandRunManager);

        try {
            console.start();
        } catch (IOException e) {
            outputManager.println("Could not read the file. Check if it is available.");
        } catch (JsonSyntaxException | IllegalArgumentException e) {
            outputManager.println("The file does not keep data in correct format." + e.getMessage());
        } catch (Exception e) {
            outputManager.println("EOF");
        }
    }
}
