package seedu.calendar;

import seedu.command.CalendarCommand;

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

        private final String[] months = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    private final String[] HEADERS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        private static final int COLUMN_SIZE = 7;
    private static final String HORIZONTAL_SEP = "-";

    private List<String[]> rows = new ArrayList<>();

    private final int DEFAULT_WIDTH = 20;
    private static int startingDay;
    private static int totalDays;
    private static int totalWeeks;
    private int dateCounter = 1;

    public GenerateCalendar(int startingDay, int totalDays, int totalWeeks) {
        this.startingDay = startingDay;
        this.totalDays = totalDays;
        this.totalWeeks = totalWeeks;
    }

    public void addRow(String... cells) {
        rows.add(cells);
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

        //printLine();

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
            currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "s", VERTICAL_MARK, PADDING);
        }

        // remainder of first week
        for (int i = startingDay; i < DAYS_IN_WEEK; i++) {
            currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "d", VERTICAL_MARK, dateCounter);
            dateCounter++;
        }
        currentWeek += VERTICAL_MARK;
        System.out.println(currentWeek);
        return currentWeek;
    }

    private String printRow() {
        String currentWeek = "";
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            if (dateCounter <= totalDays) {
                currentWeek += String.format("%s%-" + DEFAULT_WIDTH + "d", VERTICAL_MARK, dateCounter);
                dateCounter++;
            }
        }
        currentWeek += VERTICAL_MARK;
        System.out.println(currentWeek);
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
