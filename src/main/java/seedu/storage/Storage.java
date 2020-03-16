package seedu.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import seedu.tasklist.TaskList;
import seedu.tasks.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    private static final java.nio.file.Path FOLDER_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Save");
    private static final java.nio.file.Path FILE_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Save", "data.txt");

    /**
     * Locate folder location and check availability.
     * If missing create folder.
     */
    public static void checkFolderPath() {
        boolean directoryExists = java.nio.file.Files.exists(FOLDER_PATH);
        if (!directoryExists) {
            try {
                Files.createDirectory(FOLDER_PATH);
            } catch (IOException e) {
                System.out.println("Error creating folder!\n");
            }
        }
    }

    /**
     * Check whether data file has is present in directory.
     *
     * @return status of file availability
     */
    public static boolean checkFileExists() {
        boolean fileExists = java.nio.file.Files.exists(FILE_PATH);
        return fileExists;
    }

    public static String convertToGson(ArrayList<Task> taskList) {
        Gson gsonTaskList = new Gson();
        return gsonTaskList.toJson(taskList);
    }

    public static String convertToGson(Task task) {
        Gson gsonTaskList = new Gson();
        return gsonTaskList.toJson(task);
    }

    /**
     * Converting data file input string to Task objects within array list.
     * will change to read string by string instead, to prevent buffer overflow.
     * @param gsonTaskList data file contents saved within a string
     * @return arraylist of task objects
     */
    public static ArrayList<Task> convertFromGson(String gsonTaskList) {
        Type userListType = new TypeToken<ArrayList<Task>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(gsonTaskList, userListType);
    }


    /**
     * Over writes saved data file with latest task list.
     *
     * @param taskList current task list for saving
     */
    public static void overwriteFile(ArrayList<Task> taskList) {
        String formattedTaskList = convertToGson(taskList);
        try {
            File file = new File(String.valueOf(FILE_PATH));
            FileWriter myWriter = new FileWriter(file, false);
            myWriter.write(formattedTaskList);
            myWriter.close();
            //System.out.println("Successfully updated data file!\n");
        } catch (IOException e) {
            System.out.println("[Error] File cannot be written!\n");
        }
    }

    /*
    public static void saveTaskToFile(Task task) {
        String formattedTask = convertToGson(task);
        try {
            File file = new File(String.valueOf(FILE_PATH));
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(formattedTask);
            myWriter.close();
            //System.out.println("Successfully updated data file!\n");
        } catch (IOException e) {
            System.out.println("[Error] File cannot be written!\n");
        }
    }
     */

    /**
     * Reading in data file and storing into tasklist.
     * @param taskList tasklist object created in main
     */
    public void loadFromFile(TaskList taskList) {
        try {
            String gsonTaskList = new String(Files.readAllBytes(Paths.get(String.valueOf(FILE_PATH))));
            if (!gsonTaskList.isBlank()) {
                //System.out.println(gsonTaskList);
                ArrayList<Task> tasks = convertFromGson(gsonTaskList);
                taskList.updateTaskList(tasks);
            }
        } catch (IOException e) {
            System.out.println("Error reading data file! \n");
        }
    }
}
