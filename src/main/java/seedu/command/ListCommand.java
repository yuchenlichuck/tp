package seedu.command;

import seedu.exception.ProjException;
import java.util.ArrayList;
import static seedu.common.Constants.TAB;
import seedu.ui.Ui;
import seedu.tasks.Task;

public class ListCommand extends Command {

    private String userInput;


    public static final String COMMAND_WORD = "list";
    public static final String COMMAND_USAGE = COMMAND_WORD + ": lists the tasks in the calendar";

    private static final int LIST_ALL = 1;
    private static final int LIST_BY_CATEGORY = 2;
    private static final int LIST_BY_DATE = 3;
    private static final String CLASS_CATEGORY = "CLASS";

    public ListCommand(String userCommand) {
        this.userInput = userCommand;
    }

    @Override
    public CommandResult execute() throws ProjException {

        String feedback = "";
        ArrayList<Integer> listTaskIndex = new ArrayList<>();

        String category = getCategory(userInput).trim().toUpperCase();
        String date = getDate(userInput).trim();
        String time = getTime(userInput).trim();

        int listCmdSubtype = getCmdSubtype(category, date);

        switch (listCmdSubtype) {
        case LIST_ALL:
            getWholeList(listTaskIndex);
            break;

        case LIST_BY_CATEGORY:
            getListByCategory(listTaskIndex, category);
            break;
        /*
        case LIST_BY_DATE:
            getListByDate(listTaskIndex, date, time);
            break;
         */

        default:
            // Should not reach here
            break;
        }

        feedback = getFormattedFeedback(listTaskIndex);

        return new CommandResult(feedback);
    }

    // Shouldn't be called dummy
    /*
    private void getListByDate(ArrayList<Integer> listTaskIndex, String date, String time) {
        Task dummy = new Task(date, time);

        for (int i = 0; i < taskList.getListSize(); i++) {

            String category = taskList.getTask(i).getCategory().trim();

            String otherDate = "";
            if (!taskList.getTask(i).getDate().isEmpty()) {
                otherDate = taskList.getTask(i).getDate().get(0).trim();
            }

            String otherTime = "";
            if (!taskList.getTask(i).getTime().isEmpty()) {
                otherTime = taskList.getTask(i).getTime().get(0).trim();
            }

            String thisTime = dummy.getTime().get(0).trim();
            String thisDate = dummy.getDate().get(0).trim();

            if (category.equals(CLASS_CATEGORY)) {
                continue;
            }

            if (thisTime.equals(otherTime) && thisDate.equals(otherDate)) {
                listTaskIndex.add(i);
                continue;
            }

            if (thisDate.equals(otherDate) && time.isEmpty()) {
                listTaskIndex.add(i);
            }
        }

    }
     */

    private void getWholeList(ArrayList<Integer> listTaskIndex) {
        for (int i = 0; i < taskList.getListSize(); i++) {
            listTaskIndex.add(i);
        }
    }

    private String getFormattedFeedback(ArrayList<Integer> listTaskIndex) {
        String feedback = "There are " + listTaskIndex.size() + " tasks.\n";

        for (int i = 0; i < listTaskIndex.size(); i++) {
            Integer taskIndex = listTaskIndex.get(i);
            feedback += TAB + TAB + (i + 1) + ". ";
            feedback += taskList.getTask(taskIndex) + "\n";
        }

        return feedback;
    }

    private void getListByCategory(ArrayList<Integer> listTaskIndex, String category) throws ProjException {

        if (!taskList.containsCategory(category)) {
            ui.showAllCategory(taskList.getAllCategory());
            throw new ProjException(TAB + "There is no " + category + " in current category.\n"
                    + Ui.DIVIDER);
        }

        for (Integer taskIndex : taskList.getCategoryTask(category)) {
            listTaskIndex.add(taskIndex);
        }
    }

    private int getCmdSubtype(String category, String date) {

        if (date.isEmpty() && !category.isEmpty()) {
            return LIST_BY_CATEGORY;
        }

        if (!date.isEmpty() && category.isEmpty()) {
            return LIST_BY_DATE;
        }

        return LIST_ALL;
    }


}
