package seedu.command;

import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

public abstract class AddCommand extends Command {

    //add  n/<NAME> t/<Time> d/<DATE> i/<INFORMATION> l/<LOCATION> r/<REMINDER>
    private String userInput;
    private char taskType;

    protected static final String TITLE = "n/";
    protected static final String TIME = "t/";
    protected static final String DATE = "d/";
    protected static final String DESCRIPTION = "i/";
    protected static final String LOCATION = "l/";
    protected static final String REMINDER = "r/";

    //    public AddCommand(String userCommand, int wordArrayLength, char taskType) {
    //        this.userInput = userCommand;
    //        this.wordArrayLength  = wordArrayLength;
    //        this.taskType = taskType;
    //    }
    //
    //    /**
    //     * Checks if the input task format is correct for deadline and event.
    //     *
    //     * @return True if it is correct.
    //     */
    //    private Boolean isFormatCorrect() {
    //        String[] inputSections = userInput.split("\\s+");
    //        int dividerPosition = userInput.indexOf("/");
    //        if (inputSections.length < 4) {
    //            /** handle command : command / time*/
    //            return false;
    //        } else if (dividerPosition == -1) {
    //            /** handle command : command task/ time */
    //             return false;
    //        } else if (dividerPosition == userInput.length() - 1) {
    //            /** handle command without time*/
    //            return false;
    //        } else if (taskType == TASK_DEADLINE) {
    //            /** handle command: deadline / time task*/
    //            int deadlineDividerPosition = userInput.indexOf("/");
    //            if(deadlineDividerPosition == DEADLINE_LENGTH + 1) {
    //                return false;
    //            }
    //        } else if (taskType == TASK_EVENT) {
    //            /** handle command: event / time task*/
    //            int eventDividerPosition = userInput.indexOf("/");
    //            if(eventDividerPosition == EVENT_LENGTH + 1) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //
    //
    //    /**
    //     * Adds different types of tasks in list
    //     */
    //    @Override
    //    public void execute() throws ProjException {
    //        String[] inputSections = userInput.split("\\s+");
    //        if (inputSections.length < 2) {
    //            throw new ProjException("The description of a task cannot be empty.");
    //        }
    //        switch (taskType) {
    //        case TASK_DEADLINE:
    //            /** Format: deadline tasks / yyyy-mm-dd*/
    //            if (!isFormatCorrect()) {
    //                throw new ProjException("Please follow the format: deadline tasks / yyyy-mm-dd");
    //            }
    //            tasks.addDeadline(userInput, wordArrayLength);
    //            break;
    //        case TASK_EVENT:
    //            /** Format: event tasks / yyyy-mm-dd*/
    //            if (!isFormatCorrect()) {
    //                throw new ProjException("Please follow the format: deadline tasks / yyyy-mm-dd");
    //            }
    //            tasks.addEvent(userInput, wordArrayLength);
    //            break;
    //        case TASK_TODO:
    //            /** Format: todo tasks*/
    //            tasks.addTodo(userInput, wordArrayLength);
    //            break;
    //        default:
    //            System.out.println("[Error][New Task]: Keyword not recognised!\n");
    //            System.out.println("Task types:\ntodo\nevent\ndeadline");
    //        }
    //        /**
    //         * Can replace the userInput into the task type.
    //         * E.g. Ui.showAddTask(Task tasks[i]) where i is the index of the newly added tasks
    //         */
    //        Ui.showAddTask(userInput,tasks.size());
    //        //storage.writeToFile(tasks);
    //    }

    /**
     * Gets the title, if any, from the user input.
     *
     * @param userInput raw user input
     * @return title
     */
    public String getTitle(String userInput) {

        String title = "";

        if (userInput.contains(TITLE)) {
            int index = userInput.indexOf(TITLE);

            title = findField(userInput, index);
            return title;
        }

        return title;
    }

    /**
     * Gets the description, if any, from the user input.
     *
     * @param userInput raw user input
     * @return description
     */
    public String getDescription(String userInput) {

        String description = "";

        if (userInput.contains(DESCRIPTION)) {
            int index = userInput.indexOf(DESCRIPTION);

            description = findField(userInput, index);
            return description;
        }

        return description;
    }


    /**
     * Gets the date, if any, from the user input.
     *
     * @param userInput raw user input
     * @return date
     */
    public String getDate(String userInput) {

        String date = "";

        if (userInput.contains(DATE)) {
            int index = userInput.indexOf(DATE);

            date = findField(userInput, index);
            return date;
        }

        return date;
    }

    public String getReminder(String userInput) {
        String reminder = "";
        if (userInput.contains(REMINDER)) {
            int index = userInput.indexOf(REMINDER);
            reminder = findField(userInput, index);
            return reminder;
        }
        return reminder;
    }

    public String getTime(String userInput) {
        String time = "";
        if (userInput.contains(TIME)) {
            int index = userInput.indexOf(TIME);
            time = findField(userInput, index);
            return time;
        }
        return time;
    }

    public String getLocation(String userInput) {
        String location = "";
        if (userInput.contains(LOCATION)) {
            int index = userInput.indexOf(LOCATION);
            location = findField(userInput, index);
            return location;
        }
        return location;
    }

    /**
     * Scans the raw user input to search for the input.
     * for a field (e.g. "essay" in event n/essay i/world religions)
     *
     * @param userInput raw user input
     * @param fromIndex index marking the beginning of the field
     * @return expected field
     */
    private String findField(String userInput, int fromIndex) {

        String field = "";

        char nextField = '/';
        int i = fromIndex + 2;

        while (i < userInput.length() && userInput.charAt(i) != nextField) {
            field += userInput.charAt(i);
            i++;
        }

        if (i < userInput.length() && userInput.charAt(i) == nextField) {
            return field.substring(0, field.length() - 1);
        }

        return field;
    }


}
