package seedu.cafs;

import org.junit.jupiter.api.Test;
import seedu.command.AddCommand;
import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCommandTest {

    @Test
    public void testAddDeadline1() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String input = "add n/task t/11:15 d/2020-04-12";
        String expected = "[TODO] Title: task | Date: 2020-04-12 | Time: 11.15 AM";

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
    public void testAddDeadline() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String input = "add n/task t/20:18 d/2020-04-10";
        String expected = "[TODO] Title: task | Date: 2020-04-10 | Time: 08.18 PM";

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
    public void addCommand_noTitle_exceptionThrown() {

        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        try {
            String firstInput = "add";
            AddCommand firstCommand = new AddCommand(firstInput);
            firstCommand.setCommandVariables(tasks, storage, ui);
            firstCommand.execute();

        } catch (ProjException e) {
            assertEquals("Please input a title for the task.", e.getMessage());
        }
    }
}
