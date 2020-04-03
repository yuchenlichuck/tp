package seedu.calendar;

import seedu.command.CalendarCommand;
import seedu.tasklist.TaskList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    public class GenerateCalendar {
    public static final String VERTICAL_MARK = "|";
    public static final String JOIN_MARK = "+";
    public static final int SYMBOL_SIZE = 2;
    public static final int DAYS_IN_WEEK = 7;
    public static final String PADDING = " ";
        public static final int FIRST_DATE_OF_MONTH = 1;

        private final String[] months = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    private final String[] HEADERS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int COLUMN_SIZE = 7;
    private static final String HORIZONTAL_SEP = "-";
    private static final String TASK_IN_DAY = "Items due: ";
    private final int DEFAULT_WIDTH = 15;
    private final String NEW_LINE = System.lineSeparator();
    private final String NO_ENTRY = String.format("%s%-" + DEFAULT_WIDTH + "s", VERTICAL_MARK, PADDING);

    private List<String[]> rows = new ArrayList<>();


    private static int startingDay;
    private static int totalDays;
    private static int totalWeeks;
    private int dateCounter = 1;
    private int currentMonth;
    private int currentYear;
    private LocalDate date;
    private String[] tasksInWeek = new String[7];

    public GenerateCalendar(int startingDay, int totalDays, int totalWeeks, int currentMonth, int currentYear) {
        this.startingDay = startingDay;
        this.totalDays = totalDays;
        this.totalWeeks = totalWeeks;
        this.currentMonth = currentMonth + 1;
        this.currentYear = currentYear;
    }

    public void print() {

        // printing header and box around it
        printLine();
        printHeader();
        printLine();

        // first week
        printFirstRow();
        printLine();

        while(dateCounter <= totalDays) {
            printRow();
            printLine();
        }
    }

    private void printLine() {
        for (int i = 0; i < COLUMN_SIZE; i++) {
            String line = String.join("", Collections.nCopies( DEFAULT_WIDTH, HORIZONTAL_SEP));
            System.out.print(JOIN_MARK + line);
        }
        System.out.println("+"); //the last plus to end the table
    }



    private String printFirstRow() {
        // padding for first week
        String currentWeek = "";
        for (int i = 0; i < startingDay; i++) {
            currentWeek += NO_ENTRY;
        }

        // remainder of first week
        for (int i = startingDay; i < DAYS_IN_WEEK; i++) {
            currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "d", VERTICAL_MARK, dateCounter);

            date = LocalDate.of(currentYear,currentMonth, dateCounter);
            int taskCounter = TaskList.categoryCounter(date);
            if (taskCounter == 0) {
                tasksInWeek[i] = null;
            } else {
                tasksInWeek[i] = String.valueOf(taskCounter);
            }
            dateCounter++;
        }
        currentWeek += VERTICAL_MARK;
        currentWeek += NEW_LINE;

        currentWeek = getDailyTasks(currentWeek);
        currentWeek += VERTICAL_MARK;
        System.out.println(currentWeek);
        return currentWeek;
    }

    private String printRow() {
        String currentWeek = "";
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            if (dateCounter <= totalDays) {
                currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "d", VERTICAL_MARK, dateCounter);
                date = LocalDate.of(currentYear,currentMonth, dateCounter);
                int taskCounter = TaskList.categoryCounter(date);
                if (taskCounter == 0) {
                    tasksInWeek[i] = null;
                } else {
                    tasksInWeek[i] = String.valueOf(taskCounter);
                }
            } else {
                currentWeek += NO_ENTRY;
            }
            dateCounter++;
        }
        currentWeek += VERTICAL_MARK;
        currentWeek += NEW_LINE;
        currentWeek = getDailyTasks(currentWeek);
        currentWeek += VERTICAL_MARK;
        System.out.println(currentWeek);
        return currentWeek;
    }

        private String getDailyTasks(String currentWeek) {
            for (int i = 0; i < DAYS_IN_WEEK; i++) {
                if (tasksInWeek[i] == null) {
                    currentWeek += NO_ENTRY;
                } else {
                    String calendarInput = TASK_IN_DAY + tasksInWeek[i];
                    currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "s", VERTICAL_MARK, calendarInput);
                }
            }
            return currentWeek;
        }

        private void printHeader() {
        for (String day : HEADERS) {
            int padding = DEFAULT_WIDTH + SYMBOL_SIZE - day.length();
            System.out.printf("%s%-" + DEFAULT_WIDTH + "s", VERTICAL_MARK, day);
        }
        System.out.println(VERTICAL_MARK);
    }






}
