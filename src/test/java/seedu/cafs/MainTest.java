package seedu.cafs;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.command.Command;
import seedu.command.DeadlineCommand;
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
    public void deadlineTest() {
        String input = "deadline t/20:18";
        String expected = "Title: (No Title) | Description: (No Description) | Time: 08.18 PM";

        DeadlineCommand command = new DeadlineCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        command.execute();

        String output = tasks.getTask(0).toString();

        boolean isEqual = output.equals(expected);

        assertTrue(isEqual);
    }
    

    @Test
    public void sampleTest() {
        String input = "deadline n/research paper d/02-04-2020 i/essay for writing 101";
        String expected = "Title: research paper  | Date: 02-04-2020  | Description: essay for writing 101";

        DeadlineCommand command = new DeadlineCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        command.execute();

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
}