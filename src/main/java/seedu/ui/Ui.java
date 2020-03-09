package seedu.ui;

import java.util.Scanner;

public class Ui {

    /** A platform independent line separator. */
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DIVIDER = "________________________________________";

    private  static final  String LOGO =
                " ______     ______     ______   ______\n"
                + "/\\  ___\\   /\\  __ \\   /\\  ___\\ /\\  ___\\\n"
                + "\\ \\ \\____  \\ \\  __ \\  \\ \\  __\\ \\ \\___  \\\n"
                + " \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\    \\/\\_____\\\n"
                + "  \\/_____/   \\/_/\\/_/   \\/_/     \\/_____/\n";

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
     * Method used to print all messages back to user
     * Meant to improve performance by reducing number of system calls used
     *
     * @param messages  Variable length argument to display to users
     */
    public void showUserMessage(String... messages) {
        for (String message : messages)
        System.out.println(message);
    }

    public void showWelcome() {
        showUserMessage(LOGO, NEW_LINE);
    }

    /**
     * Prompts user for input
     *
     * @return String containing user command for parsing
     */
    public static String readCommand() {
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        String userCommand = input.nextLine();
        return userCommand;
    }
}
