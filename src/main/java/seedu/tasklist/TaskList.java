package seedu.tasklist;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<String> tasks;

    public TaskList() {
        tasks = new ArrayList<String>();
    }

    public static void addDeadline(String userInput, int wordArrayLength) {
        tasks.add(userInput);
    }

    public static void addEvent(String userInput, int wordArrayLength) {
        tasks.add(userInput);
    }

    public static void addTodo(String userInput, int wordArrayLength) {
        tasks.add(userInput);
    }

    public static int size() {
        return tasks.size();
    }

    public static String getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }
}
