package seedu.command;

import org.junit.jupiter.api.Test;
import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.common.Constants.TAB;

public class CalendarCommandTest {

    TaskList tasks = new TaskList();
    Ui ui = new Ui();
    Storage storage = new Storage();

    @Test
    void checkNoInput() {

        Command command = new CalendarCommand(null);
        command.setCommandVariables(tasks, storage, ui);
        try {
            command.execute().getFeedback();
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void checkValidInput() {

        Command command = new CalendarCommand("2");
        command.setCommandVariables(tasks, storage, ui);
        try {
            String output = command.execute().getFeedback();
            assertNotNull(output);
        } catch (Exception e) {
            assertTrue(false);
        }

    }

}
