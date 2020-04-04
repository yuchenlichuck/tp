package seedu.tasklist;

import seedu.tasks.Task;
<<<<<<< HEAD

=======
import seedu.tasks.TaskNonclass;

import java.time.LocalDate;
>>>>>>> 8cf473be68673f42bd58d32c933d6b56d5f56045
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class TaskList {

    private static ArrayList<Task> taskList;
    private static HashMap<String, ArrayList<Integer>> categoryMap = new HashMap<>();

    public TaskList() {
        taskList = new ArrayList<Task>();
    }

    //Accessors:
    public int getListSize() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    // TODO Fix so that method returns a deep copy of the list
    public ArrayList<Task> getList() {
        return taskList;
    }

    //Mutator methods:
    public void changeDescription(int taskIndex, String newDescription) {
        taskList.get(taskIndex).setDescription(newDescription);
    }

    public void changeDate(int taskIndex, String newDate) {
        taskList.get(taskIndex).setDate(newDate);
    }

    public void changeTime(int taskIndex, String newTime) {
        taskList.get(taskIndex).setTime(newTime);
    }

    public void changeLocation(int taskIndex, String newLocation) {
        taskList.get(taskIndex).setLocation(newLocation);
    }

    public void changeReminder(int taskIndex, String newReminder) {
        taskList.get(taskIndex).setReminder(newReminder);
    }

    /**
     * Change category of a task and change the category mapping.
     *
     * @param taskIndex   Index of task that needs to be changed.
     * @param newCategory Newly category.
     */
    public void changeCategory(int taskIndex, String newCategory) {
        String oldCategory = taskList.get(taskIndex).getCategory();
        this.categoryMap.get(oldCategory).remove(taskIndex);
        taskList.get(taskIndex).setCategory(newCategory);
        updateCategoryMap(newCategory, taskIndex);
    }

    /**
     * Change category of a task and change the category mapping.
     *
     * @param taskIndex   Index of task that needs to be changed.
     * @param category delete category.
     */
    public void deleteCategory(int taskIndex, String category) {
        this.categoryMap.get(category).remove(taskIndex);
        if (this.categoryMap.get(category).size() == 0) {
            this.categoryMap.remove(category);
        }
    }


    //Methods:

    /**
     * Checks if the given task contains the given pattern.
     *
     * @param task    task to inspect
     * @param pattern pattern to look for in task
     * @return true if task contains pattern
     */
    private boolean hasPattern(Task task, String pattern) {
        return task.getTitle().contains(pattern) || task.getDescription().contains(pattern);
    }

    private void updateCategoryMap(String category, Integer index) {
        if (category.length() != 0) {
            if (!categoryMap.containsKey(category)) {
                this.categoryMap.put(category, new ArrayList<>());
            }
            this.categoryMap.get(category).add(index);
        }
    }

    /**
     * Add tasks and update the category mapping.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        taskList.add(task);
        updateCategoryMap(task.getCategory(), taskList.size() - 1);
    }

    /**
     * When updating a task from the storage, also need to add category mapping.
     *
     * @param tasks tasks loaded.
     */
    public void updateTaskList(ArrayList<Task> tasks) {
        taskList = tasks;
        Integer index = 0;
        categoryMap.clear();
        for (Task task : tasks) {
            updateCategoryMap(task.getCategory(), index);
            index++;
        }
    }

    /**
     * Removes a task and return a reference to that object.
     *
     * @param index Index of task to remove
     * @return Removed task
     */
    public Task deleteTask(int index) {

        String category = taskList.get(index).getCategory();
        categoryMap.get(category).remove(index);
        if (categoryMap.get(category).size() == 0) {
            categoryMap.remove(category);
        }
        Task toRemove = taskList.get(index);
        taskList.remove(index);
        return toRemove;
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



    public Boolean containsCategory(String category) {
        return this.categoryMap.containsKey(category);
    }

    public ArrayList<Integer> getCategoryTask(String category) {
        return this.categoryMap.get(category);
    }

    public String[] getAllCategory() {
        return this.categoryMap.keySet().toArray(new String[this.categoryMap.size()]);
    }

    /**
     * Checks list of tasks with supplied date to see how many tasks for that date.
     *
     * @param checkDate date used to check against list
     * @return number of tasks for that day
     */
    public static int categoryCounter(LocalDate checkDate) {
        int totalTasksDay = 0;
        // searching every task to see if date matches
        for (Task task : taskList) {
            int matchedTask;
            TaskNonclass taskNonClass = (TaskNonclass) task;
            LocalDate taskDate = taskNonClass.getDate();
            matchedTask = checkDate.compareTo(taskDate);
            if (matchedTask == 0) {
                totalTasksDay++;
            }
        }
        return totalTasksDay;
    }
}
