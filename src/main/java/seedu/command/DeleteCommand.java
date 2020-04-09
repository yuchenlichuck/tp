package seedu.command;

import seedu.calendar.CalendarParser;
import seedu.common.Messages;
import seedu.exception.CommandExceptions.EmptyTaskListException;
import seedu.exception.CommandExceptions.TaskOutOfBoundsException;
import seedu.exception.ProjException;
import seedu.tasks.Class;
import seedu.tasks.Task;
import seedu.tasks.TaskNonclass;
import seedu.ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import static seedu.common.Constants.TAB;

public class DeleteCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "delete";
    public static final String COMMAND_INFO = COMMAND_WORD + ": deletes tasks from the list"
            + " (e.g all tasks or by category)";
    public static final String COMMAND_USAGE = COMMAND_WORD + " [TASK_INDEX]" + System.lineSeparator() + TAB + TAB + TAB
            + COMMAND_WORD + " c/[CATEGORY]" + System.lineSeparator() + TAB + TAB + TAB
            + COMMAND_WORD + " d/[DD-MM-YYYY]" + System.lineSeparator() + TAB + TAB + TAB
            + COMMAND_WORD + " d/[DD-MM-YYYY] t/[HH:MM-HH:MM]";


    private static final int LIST_ERROR = 0;
    private static final int LIST_ALL = 1;
    private static final int LIST_BY_CATEGORY = 2;
    private static final int LIST_BY_DATE = 3;
    private static final int LIST_BY_DATE_CATEGORY = 4;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() throws ProjException {

        String feedback = "";
        String[] commandSections = userInput.split(" ");
        if (commandSections.length < 2) {
            throw new ProjException("Please input correctly. E.g: delete 2\n");
        }
        int len = commandSections.length;
        String category = getCategory(userInput).trim().toUpperCase();
        String date = getDate(userInput).trim();
        String time = getTime(userInput).trim();
        int listCmdSubtype = getCmdSubtype(category, date, time, len);
        try {
            checkForEmptyList();

            switch (listCmdSubtype) {
            case LIST_ALL:
                String strIndex = commandSections[1].trim();
                int index = Integer.parseInt(strIndex) - 1;
                checkForValidIndex(index);
                assert index < taskList.getListSize() : "index > the size of taskList";
                feedback = getAll(index);
                break;

            case LIST_BY_CATEGORY:
                feedback = getListByCategory(category);
                break;

            case LIST_BY_DATE_CATEGORY:
                feedback = getListByDateCategory(date, time, category);
                break;
            default:
                // Should not reach here
                feedback = "[Error][List] No such option to filter";
                break;
            }

        } catch (TaskOutOfBoundsException e) {
            feedback = String.format(Messages.MESSAGE_OUT_OF_BOUNDS, commandSections[1].trim(), taskList.getListSize());

        } catch (IndexOutOfBoundsException e) {
            feedback = Messages.MESSAGE_MISSING_NUMBER;
        } catch (NumberFormatException e) {
            feedback = String.format(Messages.MESSAGE_INVALID_INDEX, commandSections[1]);

        } catch (EmptyTaskListException e) {
            feedback = String.format(Messages.MESSAGE_LIST_IS_EMPTY, COMMAND_WORD);

        } finally {
            System.out.println(feedback);
            return new CommandResult(feedback);
        }
    }

    private void checkForEmptyList() throws EmptyTaskListException {
        if (taskList.getListSize() == 0) {
            throw new EmptyTaskListException();
        }
    }

    private void checkForValidIndex(int index) throws TaskOutOfBoundsException {

        if (index < 0 || index >= taskList.getListSize()) {
            throw new TaskOutOfBoundsException();
        }
    }

    private String formatSuccessFeedback(Task removed) {

        String feedback = "";

        String description = TAB + removed.toString() + System.lineSeparator();
        description += String.format(TAB + Messages.MESSAGE_REMAINING_TASKS, taskList.getListSize());
        description += System.lineSeparator();
        feedback = String.format(Messages.MESSAGE_DELETE_SUCCESS, description);

        return feedback;
    }

    private String getListByDateCategory(String date, String time, String category) {

        //only task can do it just get by date
        String feedback = "";
        if (time == null || time.isEmpty()) {
            String[] dates = date.split("\\s+");

            //dates input dates
            HashSet<LocalDate> inputDates = new HashSet<>();
            for (String d : dates) {
                LocalDate addedDate = CalendarParser.convertToDate(d);
                if (addedDate.compareTo(LocalDate.now()) < 0) {
                    throw new NumberFormatException("Please enter a date that is either today or in the future.");
                }
                inputDates.add(addedDate);
            }

            int index = -1;
            int size = inputDates.size();

            for (int m = 0; m < taskList.getListSize(); m++) {
                Task task = taskList.getTask(m);
                if (!category.isEmpty() && !task.getCategory().equals(category)) {
                    continue;
                }

                if (task.getCategory().equals("CLASS")) {
                    continue;
                }

                ArrayList<LocalDate> localDates = task.getDate();
                int sum = 0;

                for (LocalDate d : localDates) {
                    if (inputDates.contains(d)) {
                        sum++;
                    }

                    if (sum >= size) {
                        Task removedTask = taskList.deleteTask(m);
                        storage.overwriteFile(taskList.getList());
                        assert removedTask != null : "Removed-task is null";
                        feedback += formatSuccessFeedback(removedTask) + "\n";
                        m--;
                        break;
                    }

                }
            }
        }
        // just get by time
        if (date.isEmpty()) {
            String[] times = time.split("\\s+");
            ArrayList<LocalTime> startTimes = new ArrayList<>();
            ArrayList<LocalTime> endTimes = new ArrayList<>();
            for (String atime : times) {
                String[] timeRange = atime.split("-");
                LocalTime startTime = LocalTime.parse(timeRange[0], DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime endTime = LocalTime.parse(timeRange[1], DateTimeFormatter.ofPattern("HH:mm"));
                startTimes.add(startTime);
                endTimes.add(endTime);
            }

            int size = startTimes.size();

            for (int i = 0; i < taskList.getListSize(); i++) {
                Task task = taskList.getTask(i);
                if (!category.isEmpty() && !task.getCategory().equals(category)) {
                    continue;
                }
                ArrayList<LocalTime> localTimes = task.getTime();

                int sum = 0;
                for (int j = 0; j < localTimes.size() / 2; j++) {
                    for (int k = 0; k < size; k++) {

                        if (localTimes.get(2 * j).equals(startTimes.get(k))
                                && localTimes.get(2 * j + 1).equals(endTimes.get(k))) {
                            sum++;
                        }
                    }

                    if (sum >= size) {
                        Task removedTask = taskList.deleteTask(i);

                        storage.overwriteFile(taskList.getList());
                        assert removedTask != null : "Removed-task is null";
                        feedback += formatSuccessFeedback(removedTask) + "\n";
                        i--;
                        break;

                    }
                }
            }

        }

        //date and time
        if (!date.isEmpty() && !time.isEmpty()) {
            String[] dates = date.split("\\s+");
            String[] times = time.split("\\s+");
            ArrayList<LocalTime> startTimes = new ArrayList<>();
            ArrayList<LocalTime> endTimes = new ArrayList<>();
            ArrayList<LocalDate> dateList = new ArrayList<>();

            for (String atime : times) {
                String[] timeRange = atime.split("-");
                LocalTime startTime = LocalTime.parse(timeRange[0], DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime endTime = LocalTime.parse(timeRange[1], DateTimeFormatter.ofPattern("HH:mm"));
                startTimes.add(startTime);
                endTimes.add(endTime);
            }

            for (String adate : dates) {
                dateList.add(LocalDate.parse(adate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }

            //dates input dates
            int size = dates.length;

            for (int i = 0; i < taskList.getListSize(); i++) {
                Task task = taskList.getTask(i);
                if (!category.isEmpty() && !task.getCategory().equals(category)) {
                    continue;
                }

                if (task.getCategory().equals("CLASS")) {
                    continue;
                }

                ArrayList<LocalTime> localTimes = task.getTime();
                ArrayList<LocalDate> localDates = task.getDate();

                int sum = 0;

                for (int j = 0; j < localDates.size(); j++) {
                    for (int k = 0; k < dateList.size(); k++) {
                        if (localTimes.get(2 * j).equals(startTimes.get(k))
                                && localTimes.get(2 * j + 1).equals(endTimes.get(k))
                                && localDates.get(j).equals(dateList.get(k))) {
                            sum++;
                        }
                    }

                    if (sum >= size) {
                        Task removedTask = taskList.deleteTask(i);
                        storage.overwriteFile(taskList.getList());
                        assert removedTask != null : "Removed-task is null";
                        feedback += formatSuccessFeedback(removedTask) + "\n";
                        i--;
                        break;
                    }
                }
            }
        }
        return feedback;
    }


    private String getListByCategory(String category) throws ProjException {
        if (!taskList.containsCategory(category)) {
            ui.showAllCategory(taskList.getAllCategory());
            throw new ProjException(TAB + "There is no " + category + " in current category.\n"
                    + Ui.DIVIDER);
        }
        String feedback = "";
        for (int i = 0; i < taskList.getListSize(); i++) {

            if (taskList.getTask(i).getCategory().equals(category)) {

                Task removedTask = taskList.deleteTask(i);
                storage.overwriteFile(taskList.getList());
                i--;
                assert removedTask != null : "Removed-task is null";
                feedback += formatSuccessFeedback(removedTask) + "\n";
            }
        }
        return feedback;
    }

    private String getAll(int index) {

        Task removedTask = taskList.deleteTask(index);
        storage.overwriteFile(taskList.getList());
        return formatSuccessFeedback(removedTask);
    }

    private int getCmdSubtype(String category, String date, String time, int len) {

        if (date.isEmpty() && !category.isEmpty()) {
            return LIST_BY_CATEGORY;
        }

        if (!(date.isEmpty() && time.isEmpty())) {
            return LIST_BY_DATE_CATEGORY;
        }

        if (len == 2 && (date.isEmpty() && time.isEmpty() && category.isEmpty())) {
            return LIST_ALL;
        }

        return LIST_ERROR;
    }

}
