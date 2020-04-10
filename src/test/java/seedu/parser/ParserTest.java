package seedu.parser;

import org.junit.jupiter.api.Test;

import seedu.command.AddCommand;
import seedu.command.CalendarCommand;
import seedu.command.DeleteCommand;
import seedu.command.DoneCommand;
import seedu.command.EditCommand;
import seedu.command.ExitCommand;
import seedu.command.FindCommand;
import seedu.command.ListCommand;
import seedu.command.Command;

import seedu.common.Constants;
import seedu.common.Messages;
import seedu.exception.ProjException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.command.HelpCommand.HELP_LEGEND;
import static seedu.common.Constants.TAB;


class ParserTest {

    @Test
    public void isInteger_invalidInteger_returnFalse() {

        String invalidNumber = "1568..122";
        boolean isInvalidInt = Parser.isInteger(invalidNumber);
        assertFalse(isInvalidInt);

        invalidNumber = "abcde";
        isInvalidInt = Parser.isInteger(invalidNumber);
        assertFalse(isInvalidInt);

        invalidNumber = "1234.12";
        isInvalidInt = Parser.isInteger(invalidNumber);
        assertFalse(isInvalidInt);

        invalidNumber = "12.";
        isInvalidInt = Parser.isInteger(invalidNumber);
        assertFalse(isInvalidInt);

        invalidNumber = "0x123";
        isInvalidInt = Parser.isInteger(invalidNumber);
        assertFalse(isInvalidInt);

    }


    @Test
    public void parseCommand_ListCommand_createCommand() {

        Command command;
        String input = "list";

        command = Parser.parseCommand(input);
        boolean isListCommand = command instanceof ListCommand;
        assertTrue(isListCommand);


        input = "LiST t/12:00-13:00";
        command = Parser.parseCommand(input);
        isListCommand = command instanceof ListCommand;
        assertTrue(isListCommand);

        input = "LIST c/Category";
        command = Parser.parseCommand(input);
        isListCommand = command instanceof ListCommand;
        assertTrue(isListCommand);
    }

    @Test
    public void parseCommand_DeleteCommand_createCommand() {

        Command command;
        String input = "delete";

        command = Parser.parseCommand(input);
        boolean isListCommand = command instanceof DeleteCommand;
        assertTrue(isListCommand);


        input = "DElEte 2";
        command = Parser.parseCommand(input);
        isListCommand = command instanceof DeleteCommand;
        assertTrue(isListCommand);
    }

    @Test
    public void parseCommand_ExitCommandWithParameter_exceptionThrown() {

        Command command;
        String input = "bye 3";

        command = Parser.parseCommand(input);

        String output = "";
        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = "  [Error][bye]: No arguments required" + Constants.NEW_LINE;
        assertEquals(output,expected);

    }

    @Test
    public void parserCommand_InvalidCommand_errorMessage() {

        Command command;
        String input = "exit";

        command = Parser.parseCommand(input);

        String output = "";
        try {
            output = command.execute().getFeedback();
        } catch (ProjException e) {
            assertTrue(false);
        }

        String expected = TAB + String.format(Messages.MESSAGE_INVALID_COMMAND, input) + Constants.NEW_LINE;

        expected += HELP_LEGEND;

        expected += TAB + "Command List:\n\n";

        expected += TAB + TAB + AddCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + AddCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + EditCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + EditCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + ListCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + System.lineSeparator() + TAB + TAB + TAB
                + ListCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + DeleteCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: "  + System.lineSeparator() + TAB + TAB + TAB
                + DeleteCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + DoneCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + DoneCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + FindCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + FindCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + CalendarCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + CalendarCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        expected += TAB + TAB + ExitCommand.COMMAND_INFO + System.lineSeparator();
        expected += TAB + TAB + "Usage: " + ExitCommand.COMMAND_USAGE + System.lineSeparator();
        expected += System.lineSeparator();

        assertEquals(expected, output);

    }


}