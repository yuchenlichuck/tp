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
        String input = "add n/task t/11:15-13:15 d/2024-02-29";
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
                + "    1. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }


    @Test
    void checkListMul() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/2024-02-29";


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
                + "    1. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    2. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    3. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    4. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    5. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    6. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }


    @Test
    void testListByTime() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/2024-02-29";

        Command command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);

        try {
            command.execute();
            command.execute();

        } catch (ProjException e) {
            assertTrue(false);
        }

        input = "add n/task t/13:00-15:00 d/2028-02-19";

        command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        command = new ListCommand("list t/11:15-13:00");
        command.setCommandVariables(tasks, storage, ui);

        try {

            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "There are 2 tasks.\n"
                + "    1. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    2. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }


    @Test
    void testListByDateTime() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/2024-02-29";

        Command command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);

        try {
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        input = "add n/task t/13:00-15:00 d/2024-02-29";

        command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        input = "add n/task t/11:15-13:15 d/2024-02-28";

        command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        command = new ListCommand("list t/12:15-12:30 d/2024-02-29");
        command.setCommandVariables(tasks, storage, ui);

        try {

            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "There are 3 tasks.\n"
                + "    1. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    2. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    3. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }


    @Test
    void testListByCategory() {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage();

        String output = "";
        String input = "add n/task t/11:15-13:15 d/2024-02-29";

        Command command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);

        try {
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        input = "add n/2113 v2.1 t/23:00-24:00 d/2020-05-16 c/deadline";

        command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        input = "add t/11:00-12:00 01:00-03:00 n/2113 d/3 4 c/CLASS l/COM2 COM1";

        command = new AddCommand(input);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute();
            command.execute();
            command.execute();
            command.execute();
        } catch (ProjException e) {
            assertTrue(false);
        }

        command = new ListCommand("list c/todo");
        command.setCommandVariables(tasks, storage, ui);

        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "There are 3 tasks.\n"
                + "    1. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    2. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n"
                + "    3. [N] [TODO] Title: task | 2024-02-29 : 11:15 - 13:15\n";

        assertEquals(expected, output);
    }
}