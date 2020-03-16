package seedu.command;

import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

/**
 * Represents an executable command.
 */
public abstract class Command {

    protected TaskList taskList;
    protected Storage storage;
    protected Ui ui;

    /**
     * Called to check if exit command is given.
     *
     * @return condition whether program should continue looping or exit
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Supplies the objects other commands will call upon.
     *
     * @param taskList  current instance of tasks and corresponding tasklist methods
     * @param storage instance of storage object
     * @param ui instance of user interaction object
     */
    public void setCommandVariables(TaskList taskList, Storage storage, Ui ui) {
        this.taskList = taskList;
        this.storage = storage;
        this.ui = ui;
    }

    /**
     * Executes user command processed by parser.
     */
    public abstract CommandResult execute() throws ProjException;

}

