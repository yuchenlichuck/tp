package seedu.command;

import seedu.exception.ProjException;
import seedu.calendar.calendarParser;
import seedu.parser.Parser;

public class CalendarCommand extends Command {

    public static final String COMMAND_WORD = "calendar";
    private final String[] months= {"January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"};
    private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private int startingDay;
    private  int totalDays;
    private int totalWeeks;
    private String userInput;
    private calendarParser calendar;
    String feedback;

    public CalendarCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() throws ProjException {

        // parsing user input, if not valid int, set as default month
        if ( (userInput != null) && (Parser.isInteger(userInput)) ) {
            int month = Integer.parseInt(userInput);
           calendar = new calendarParser(month);
        } else {
            calendar = new calendarParser();
        }

        startingDay = calendar.getFirstDay();
        totalDays = calendar.getTotalDays();
        totalWeeks  =calendar.getTotalWeeks();

        // printing days
        for (String day : days) {
            feedback += String.format("%8s ",day);
        }

        feedback += String.format("\n");
        // print offsets
        String offset = "";
        for (int i = 0; i < startingDay; i++){
            feedback += String.format("%8s ",offset);
        }

        // print dates
        int dayCounter = startingDay;
        for (int i = 1; i <= totalDays; i++){
            feedback += String.format( "%8d ", i);
            dayCounter = (dayCounter + 1) % 7;
            if (dayCounter == 0) {
                feedback += String.format("\n");
            }
        }

        feedback += String.format("\n\n");
        return new CommandResult(feedback);

    }


}
