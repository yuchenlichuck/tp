package seedu.command;

import org.junit.jupiter.api.Test;
import seedu.exception.ProjException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelpCommandTest {
    @Test
    void execute() {
        Command command = new HelpCommand();
        String output = null;
        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }
        String expected;
        expected = "Legend:\n"
                + "    [Y]: Task is completed\n"
                + "    [N]: Task is not completed\n"
                + "\n"
                + "  Command List:\n"
                + "\n"
                + "    Exit: Exits program\n"
                + "    Usage: bye\n"
                + "\n"
                + "    List: Lists all recorded tasks\n"
                + "    Usage: list\n"
                + "\n"
                + "    Add: add task\n"
                + "    Usage: add n/[title] i/[description] t/[hh:mm-hh:mm] d/[dd-mm-yyyy] "
                + "l/[LOCATION] r/[REMINDER] c/[CATEGORY]\n"
                + "\n"
                + "    Delete: Deletes task from list\n"
                + "    Usage: delete [task number]\n"
                + "\n"
                + "    Find: Search for task using keyword\n"
                + "    Usage: find [pattern]\n\n";

        for (int i = 0; i < output.length(); i++) {
            if (expected.charAt(i) != output.charAt(i)) {
                assertEquals(expected.charAt(i), output.charAt(i));
            }
        }

        boolean isEqual = output.equals(expected);
        assertTrue(isEqual);


    }
}