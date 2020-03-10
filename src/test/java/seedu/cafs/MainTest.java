package seedu.cafs;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.command.DeadlineCommand;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

class MainTest {

    TaskList taskList = new TaskList();
    Ui ui = new Ui();
    Storage storage = new Storage();

    @Test
    public void sampleTest() {
        String input = "deadline n/research paper d/02-04-2020 i/essay for writing 101";
        String expected = "Title: research paper  | Date: 02-04-2020  | Description: essay for writing 101";

        DeadlineCommand command = new DeadlineCommand(input);
        command.setCommandVariables(taskList, storage, ui);
        command.execute();

        String output = taskList.getTask(0).toString();

        boolean isEqual = output.equals(expected);

        assertTrue(isEqual);
    }
}