package seedu.cafs;

import seedu.command.Command;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

/**
 * Entry point of the Address Book application.
 * Initializes the application and starts the interaction with the user.
 */
public class Main {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;


    /**
     * Main Duke constructor to set up required classes and check for data file
     */
    public Main() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList();
        // search for folder, create if not found
        storage.checkFolderPath();
        // populate if data file is found
        if (storage.checkFileExists()) {
           // storage.populateList(tasks);
        }
    }

    public void run() {
        ui.showWelcome();
        runCommandLoopUntilExitCommand();
    }

    /**
     * Reads the user command and executes it, until the user issues the exit command.
     */
    private void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userCommandText = ui.readCommand();
            command = new Parser().parseCommand(userCommandText);
            command.setCommandVariables(tasks, storage, ui);
            command.execute();
        } while (!command.isExit()); // will be solved when do is enabled
    }


    public static void main(String[] args) {
        new Main().run();
    }
}
