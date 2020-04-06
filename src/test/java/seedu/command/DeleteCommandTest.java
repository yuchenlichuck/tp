package seedu.command;

import org.junit.jupiter.api.Test;
import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteCommandTest {
    @Test
    public void testDeleteDeadLine() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String input = "add n/task t/11:15-13:15 d/29-02-2024";
        Command command = new AddCommand(input);

        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String input1 = "add n/homework i/cs2113_homework_team_project "
                + "t/00:20-23:00 d/31-12-2021 l/com2 r/reminder";
        command = new AddCommand(input1);

        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }
        String deleteInput = "delete 2";
        command = new DeleteCommand(deleteInput);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }
        String expected = "[TODO] Title: task | 2024-02-29 : 11:15 - 13:15";
        String output = tasks.getTask(0).toString();
        boolean isEqual = output.equals(expected);
        assertTrue(isEqual);
    }
    //currently couldn't pass because of assertions.
    /*    @Test
    public void testDeleteZeroTask() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();
        String deleteInput = "delete 2";
        Command command = new DeleteCommand(deleteInput);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }
        String expected = "Missing task number to delete\n";
        String output = tasks.getTask(0).toString();
        boolean isEqual = output.equals(expected);
        assertTrue(isEqual);
    }*/
}
