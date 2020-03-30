package seedu.command;

import seedu.exception.ProjException;
import java.util.ArrayList;
import static seedu.common.Constants.TAB;
import seedu.ui.Ui;

public class ListCommand extends Command {

    private String userInput;

    private static final int LIST_ALL = 1;
    private static final int LIST_BY_CATEGORY = 2;
    private static final int LIST_BY_DATE = 3;

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

        case LIST_BY_DATE:

            break;

        default:
            // Should not reach here
            break;
        }

        feedback = getFormattedFeedback(listTaskIndex);

        return new CommandResult(feedback);
    }

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
