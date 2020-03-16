package seedu.ui;

import seedu.command.CommandResult;

import java.util.Scanner;

public class Ui {

    /** A platform independent line separator. */
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DIVIDER = "_____________________________________________________________________";
    private static final String PROMPT = "> ";
    private static final String TAB = "\t";

    private  static final  String LOGO =
                " ______     ______     ______   ______\n"
                + "\t/\\  ___\\   /\\  __ \\   /\\  ___\\ /\\  ___\\\n"
                + "\t\\ \\ \\____  \\ \\  __ \\  \\ \\  __\\ \\ \\___  \\\n"
                + "\t \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\    \\/\\_____\\\n"
                + "\t  \\/_____/   \\/_/\\/_/   \\/_/     \\/_____/\n";

    private Scanner input = new Scanner(System.in);

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is only whitespace, or is empty. (add more conditions if needed)
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnoreInput(String rawInputLine) {
        return rawInputLine.trim().isEmpty();
    }


    /**
     * Method used to print all messages back to user.
     * Meant to improve performance by reducing number of system calls used.
     *
     * @param messages  Variable length argument to display to users
     */
    public void showUserMessage(String... messages) {
        System.out.println(DIVIDER);

        for (String message : messages) {
            System.out.print(TAB + message);
        }

        System.out.println(DIVIDER);
    }

    public void showWelcome() {
        showUserMessage(LOGO);
    }

    /**
     * Prompts user for input.
     *
     * @return String containing user command for parsing
     */
    public String readCommand() {
        System.out.print(PROMPT);
        String userCommand = input.nextLine();

        assert userCommand.length() > 0 : "Command input should contain at least one word";
        return userCommand;
    }

    /**
     * Prints prompt message that a task is successfully added.
     *
     * @param userInput can be replaced with Task addedTask if there is task type implemented later
     */
    public static void showAddTask(String userInput, int taskCount) {
        System.out.print("Successfully add tasks: ");
        System.out.println(userInput);
        System.out.println("There are " + taskCount + " in your list.");
    }

    public void showResultToUser(CommandResult result) {
        showUserMessage(result.getFeedback());
    }

    public void showError(String error) {
        System.out.println(error);
    }
}
