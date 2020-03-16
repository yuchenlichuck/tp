package seedu.storage;

import com.google.gson.Gson;
import seedu.tasks.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Storage {

    private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    private static final java.nio.file.Path FOLDER_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Save");
    private static final java.nio.file.Path FILE_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Save", "data.txt");
    private static Gson gsonTaskList = new Gson();

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
        return gsonTaskList.toJson(taskList);
    }

    public static void overwriteFile(ArrayList<Task> taskList) {
        String formattedTaskList = convertToGson(taskList);
        try {
            File file = new File(String.valueOf(FILE_PATH));
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(formattedTaskList);
            myWriter.close();
            System.out.println("Successfully updated data file!\n");
        } catch (IOException e) {
            System.out.println("[Error] File cannot be written!\n");
        }
    }
}
