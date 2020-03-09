package seedu.storage;

import seedu.tasklist.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Storage {

    private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    private static final java.nio.file.Path FOLDER_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Duke");
    private static final java.nio.file.Path FILE_PATH = java.nio.file.Paths.get(WORKING_DIRECTORY, "Duke", "data.txt");

    /**
     * Locate folder location and check availability.
     * If missing create folder.
     */
    public static void checkFolderPath() {

        boolean directoryExists = java.nio.file.Files.exists(FOLDER_PATH);
        try {
            if (!directoryExists) {
                Files.createDirectory(FOLDER_PATH);

                System.out.println("Directory created\n");
            } else {
                System.out.println("Directory found\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating folder!\n");
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

//    public static void writeToFile(TaskList tasks) {
//
//        try {
//            File file = new File(String.valueOf(FILE_PATH));
//            FileWriter myWriter = new FileWriter(file, true);
//            for(int i = 0; i < tasks.size(); i++) {
//                myWriter.write(tasks.getTask(i));
//            }
//            myWriter.close();
//            System.out.println("Successfully updated data file!\n");
//        } catch (IOException e) {
//
//        }
//    }

}
