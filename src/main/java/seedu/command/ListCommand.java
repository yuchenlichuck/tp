package seedu.command;

import seedu.exception.ProjException;

import java.util.ArrayList;

public class ListCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "list";
    public static final String COMMAND_USAGE = COMMAND_WORD + ": lists the tasks in the calendar";

    public ListCommand(String userCommand) {
        this.userInput = userCommand;
    }

    @Override
    public CommandResult execute() throws ProjException {

        String category = getCategory(userInput).trim().toUpperCase();
        ArrayList<Integer> listTaskIndex = new ArrayList<>();

        if (category.length() != 0) {
            if (!taskList.containsCategory(category)) {
                ui.showAllCategory(taskList.getAllCategory());
                throw new ProjException("There is no " + category + " in current category.");
            }
            for (Integer taskIndex : taskList.getCategoryTask(category)) {
                listTaskIndex.add(taskIndex);
            }
        } else {
            for (int i = 0; i < taskList.getListSize(); i++) {
                listTaskIndex.add(i);
            }
        }

        String feedback = "There are " + listTaskIndex.size() + " tasks.\n";

        for (int i = 0; i < listTaskIndex.size(); i++) {
            Integer taskIndex = listTaskIndex.get(i);
            feedback += (i + 1) + ". " + "[" + (taskIndex + 1) + "] ";
            System.out.println(taskIndex);
            feedback += taskList.getTask(taskIndex) + "\n";
        }

        return new CommandResult(feedback);
    }

}
