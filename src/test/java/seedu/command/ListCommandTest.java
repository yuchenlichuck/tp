package seedu.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

class ListCommandTest {

    @Test
    void checkListZeroException() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();
        Command command = new ListCommand("");
        command.setCommandVariables(tasks, storage, ui);
        String output = "";
        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }
        assertEquals("There are 0 task.\n", output);
    }

    @Test
    void checkListOne() {
        TaskList tasks = new TaskList();

        Ui ui = new Ui();

        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/29-02-2024";
        Command command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }
        command = new ListCommand("");
        command.setCommandVariables(tasks, storage, ui);

        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "There are 1 task.\n"
                + "    1. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }


    @Test
    void checkListMul() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/29-02-2024";


        Command command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);

        try {
            command.execute();
            command.execute();
            command.execute();
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        command = new ListCommand("");
        command.setCommandVariables(tasks, storage, ui);
        
        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "There are 6 tasks.\n"
                + "    1. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    2. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    3. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    4. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    5. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    6. [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";
        assertEquals(expected, output);
    }
}