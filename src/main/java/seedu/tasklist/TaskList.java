package seedu.tasklist;

import seedu.tasks.Task;
import java.util.ArrayList;


public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public int getListSize() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    /**
     * Finds the tasks that contain the given pattern in their
     * title or description.
     *
     * @param pattern pattern to look for in the tasks
     * @return tasks that match the pattern
     */
    public ArrayList<Task> findTasks(String pattern) {

        ArrayList<Task> foundTasks = new ArrayList<>();

        for (Task task : taskList) {
            if (hasPattern(task, pattern)) {
                foundTasks.add(task);
            }
        }

        return foundTasks;
    }

    // TODO Fix so that method returns a deep copy of the list
    public ArrayList<Task> getList() {
        return taskList;
    }

    /**
     * Checks if the given task contains the given pattern.
     *
     * @param task task to inspect
     * @param pattern pattern to look for in task
     * @return true if task contains pattern
     */
    private boolean hasPattern(Task task, String pattern) {
        return task.getTitle().contains(pattern) || task.getDescription().contains(pattern);
    }

    public void changeTitle(int taskIndex, String newTitle) {
        taskList.get(taskIndex).setTitle(newTitle);
    }

    public void changeDescription(int taskIndex, String newDescription) {
        taskList.get(taskIndex).setDescription(newDescription);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
}
