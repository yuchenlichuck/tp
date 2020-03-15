package seedu.cafs;

import org.junit.jupiter.api.Test;
import seedu.command.TodoCommand;
import seedu.command.EditCommand;
import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditCommandTest {

    @Test
    public void testCorrectOutput() {

        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String firstInput = "todo n/Sleep early";
        String firstExpected = "Title: Sleep early";
        TodoCommand firstCommand = new TodoCommand(firstInput);
        firstCommand.setCommandVariables(tasks, storage, ui);
        try {
            firstCommand.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }
        String firstOutput = tasks.getTask(0).toString();
        assertTrue(firstOutput.equals(firstExpected));

        String secondInput = "edit 1 i/for your health";
        String secondExpected = "Title: Sleep early | Description: for your health";
        EditCommand secondCommand = new EditCommand("1",secondInput);
        secondCommand.setCommandVariables(tasks, storage, ui);
        try {
            secondCommand.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String secondOutput = tasks.getTask(0).toString();
        assertTrue(secondOutput.equals(secondExpected));
    }

    @Test
    public void editCommand_editTitle_exceptionThrown() {

        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        try {
            String firstInput = "todo n/Sleep early";
            TodoCommand firstCommand = new TodoCommand(firstInput);
            firstCommand.setCommandVariables(tasks, storage, ui);
            firstCommand.execute();

            String secondInput = "edit 1 n/Sleep now";
            EditCommand secondCommand = new EditCommand("1", secondInput);
            secondCommand.setCommandVariables(tasks, storage, ui);
            secondCommand.execute();

        } catch (ProjException e) {
            assertEquals("Not allowed to change title.", e.getMessage());
        }
    }
}
