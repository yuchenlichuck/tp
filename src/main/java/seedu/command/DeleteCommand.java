package seedu.command;

import seedu.tasks.Task;

import java.time.format.DateTimeParseException;
import java.util.IllegalFormatException;
import static seedu.common.Constants.TAB;
import java.time.LocalDate;

public class DeleteCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "delete";
    public static final String COMMAND_USAGE = COMMAND_WORD + " [task number]";


    private static final String MESSAGE_SUCCESS = "The following task has been removed:\n %s";
    private static final String MESSAGE_INVALID_INDEX = "The entered index %s is invalid. + "
            + "Please enter a valid task number\n";
    private static final String MESSAGE_MISSING_NUMBER = "Missing task number to delete\n";
    private static final String MESSAGE_REMAINING_TASKS = "Now you have %d task/tasks in your calendar\n";

    private static final int DELETE_ONE = 1;
    private static final int DELETE_RANGE = 2;


    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() {

        String[] commandSections = userInput.split(" ");
        CommandResult result = null;


        String startDate = getStartDate(userInput);
        String endDate = getStartDate(userInput);

        int cmdSubtype = getCmdSubtype(startDate, endDate);


        switch (cmdSubtype) {

        case DELETE_ONE:
            result = deleteIndividualTask(commandSections);
            break;

        case DELETE_RANGE:
            deleteRangeOfTasks(startDate, endDate, result);
            break;
        }

        return result;
    }

    private void deleteRangeOfTasks(String startDate, String endDate, CommandResult result) {

        boolean hasStart = false;
        boolean hasEnd = false;

        try {
            if (!startDate.isEmpty()) {
                LocalDate start = LocalDate.parse(startDate);
                hasStart = true;
            }
            if (!endDate.isEmpty()) {
                LocalDate end = LocalDate.parse(endDate);
                hasEnd = true;
            }

            if (hasEnd && hasStart) {
                deleteMiddleRange(start, end, result);
            } else if (hasEnd) {
                deleteLeftRange(end, result);
            } else if (hasStart) {
                deleteRightRange(start, result);
            }


        } catch (DateTimeParseException e) {

        }


    }

    private CommandResult deleteIndividualTask(String[] commandSections) {

        try {
            String strIndex = commandSections[1].trim();
            int index = Integer.parseInt(strIndex) - 1;
            assert index < taskList.getListSize() : "index > the size of taskList";
            Task removedTask = taskList.deleteTask(index);

            storage.overwriteFile(taskList.getList());
            assert removedTask != null : "Removed-task is null";
            return new CommandResult(formatFeedback(removedTask));

        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(MESSAGE_MISSING_NUMBER);

        } catch (IllegalFormatException e) {
            String feedback = String.format(MESSAGE_INVALID_INDEX, commandSections[1]);
            return new CommandResult(feedback);

        }
    }

    private int getCmdSubtype(String startDate, String endDate) {

        if (!startDate.isEmpty() || !endDate.isEmpty()) {
            return DELETE_RANGE;
        }

        return DELETE_ONE;
    }

    private String formatFeedback(Task removed) {

        String feedback = "";

        String description = TAB + removed.toString() + System.lineSeparator();
        description += String.format(TAB + MESSAGE_REMAINING_TASKS, taskList.getListSize());
        description += System.lineSeparator();

        feedback = String.format(MESSAGE_SUCCESS, description);

        return feedback;
    }

}
