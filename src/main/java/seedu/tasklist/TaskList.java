package seedu.tasklist;

import seedu.tasks.Task;
import java.util.ArrayList;


public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList () {
        taskList = new ArrayList<>();
    }

    public void addTask (Task task) {
        taskList.add(task);
    }

    public void deleteTask (int index) {
        taskList.remove(index);
    }


}
