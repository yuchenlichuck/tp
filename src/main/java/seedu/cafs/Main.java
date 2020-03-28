package seedu.cafs;

import seedu.command.Command;
import seedu.command.CommandResult;
import seedu.exception.ProjException;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Entry point of the CAFS
 * Initializes the application and starts the interaction with the user.
 */
public class Main {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private static Logger logger = Logger.getLogger("Foo");

    /**
     * Main constructor to set up required classes and check for data file.
     */
    public Main() {

        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList();

        /*
        // search for folder, create if not found
        storage.checkFolderPath();

        // populate if data file is found
        if (storage.checkFileExists()) {
            // log a message at INFO level
            logger.log(Level.INFO, "Attempting to read from data file");
            storage.loadFromFile(tasks);
        }
        */
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
            try {
                CommandResult result = command.execute();
                ui.showResultToUser(result);
            } catch (ProjException e) {
                ui.showError(e.getMessage());
            }
        } while (!command.isExit()); // will be solved when do is enabled
        logger.log(Level.INFO, "end of processing");
    }


    public static void main(String[] args) {
        new Main().run();
    }
}