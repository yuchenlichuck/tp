package seedu.cafs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import seedu.command.Command;
import seedu.command.HelpCommand;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

class MainTest {

    TaskList tasks = new TaskList();
    Ui ui = new Ui();
    Storage storage = new Storage();

    @Test
    public void emptyCommandTest() {

        String testInput = "";
        Command command = new Parser().parseCommand(testInput);
        command.setCommandVariables(tasks, storage, ui);
        boolean checkIfHelpCommand = command instanceof HelpCommand;
        assertTrue(checkIfHelpCommand);

    }


}