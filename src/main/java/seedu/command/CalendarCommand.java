package seedu.command;

import seedu.calendar.GenerateCalendar;
import seedu.exception.ProjException;
import seedu.calendar.CalendarParser;
import seedu.parser.Parser;

import java.util.Calendar;

public class CalendarCommand extends Command {

    public static final String COMMAND_WORD = "calendar";
    private final String[] months = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"};
    private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private int startingDay;
    private  int totalDays;
    private int totalWeeks;
    private String userInput;
    private CalendarParser calendar;
    String feedback = "";
    private int checkMonth;
    private int currentYear;

    public CalendarCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() throws ProjException {

        // parsing user input, if not valid int, set as default month
        if ((userInput != null) && (Parser.isInteger(userInput))) {
            checkMonth = Integer.parseInt(userInput);
            calendar = new CalendarParser(checkMonth);
        } else {
            calendar = new CalendarParser();
        }
        checkMonth = calendar.getMonth();
        startingDay = calendar.getFirstDay();
        totalDays = calendar.getTotalDays();
        totalWeeks = calendar.getTotalWeeks();
        currentYear = calendar.getYear();
        System.out.println();
        GenerateCalendar gc = new GenerateCalendar(startingDay, totalDays, totalWeeks, checkMonth, currentYear);
        feedback += gc.print();
        return new CommandResult(feedback);
    }

}
