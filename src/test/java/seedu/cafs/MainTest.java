package seedu.cafs;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.command.AddCommand;
import seedu.command.Command;
import seedu.command.HelpCommand;
import seedu.exception.ProjException;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

class MainTest {
    /*
    TaskList tasks = new TaskList();
    Ui ui = new Ui();
    Storage storage = new Storage();

    @Test
    public void sampleTest() {
        String input = "add n/research paper d/02-04-2020 i/essay for writing 101";
        String expected = "[TODO] Title: research paper | Description: essay for writing 101 | Date: (Unknown Date)";

        AddCommand command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String output = tasks.getTask(0).toString();

        boolean isEqual = output.equals(expected);

        assertTrue(isEqual);
    }

    @Test
    public void emptyCommandTest() {
        String testInput = "";
        Command command = new Parser().parseCommand(testInput);
        command.setCommandVariables(tasks, storage, ui);
        boolean checkIfHelpCommand = command instanceof HelpCommand;
        assertTrue(checkIfHelpCommand);
    }

     */
}