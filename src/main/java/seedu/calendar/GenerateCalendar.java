package seedu.calendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    public class GenerateCalendar {
    public static final String VERTICAL_MARK = "|";
    public static final String JOIN_MARK = "+";
        public static final int SYMBOL_SIZE = 2;

        private final String[] months = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    private final String[] HEADERS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int COLUMN_SIZE = 7;
    private static final String HORIZONTAL_SEP = "-";

    private List<String[]> rows = new ArrayList<>();

    private final int DEFAULT_WIDTH = 20;


    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {

        /*
        for (String[] cells : rows) {
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

         */

        printLine(COLUMN_SIZE);
        //printRow(HEADERS, DEFAULT_WIDTH);
        printHeader();
        printLine(COLUMN_SIZE);

        for (String[] cells : rows) {
            printRow(cells, COLUMN_SIZE);
        }
        printLine(COLUMN_SIZE);

    }

    private void printLine(int columnWidths) {
        for (int i = 0; i < columnWidths; i++) {
            String line = String.join("", Collections.nCopies( DEFAULT_WIDTH, HORIZONTAL_SEP));
            System.out.print(JOIN_MARK + line);
        }
        System.out.println("+"); //the last plus to end the table
    }

    private void printRow(String[] cells, int maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? VERTICAL_MARK : "";
            System.out.printf("%s %-" + maxWidths + "s %s", VERTICAL_MARK, s, verStrTemp);
        }
        System.out.println();
    }

    private void printHeader() {
        for (String day : HEADERS) {
            int padding = DEFAULT_WIDTH + SYMBOL_SIZE - day.length();
            System.out.printf("%s %s %-"+ padding +"s", VERTICAL_MARK, day, " ");
        }
        System.out.println(VERTICAL_MARK);
    }



}
