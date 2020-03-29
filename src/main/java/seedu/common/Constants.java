package seedu.common;

public final class Constants {

    // TODO Can be refactored to be inside Command classes
    public static final String ADD = "add";
    public static final String LIST = "list";
    public static final String HELP = "help";
    public static final String EXIT = "bye";
    public static final String FIND = "find";
    public static final String DELETE = "delete";
    public static final String EDIT = "edit";
    public static final String CLEAR = "clc";
    public static final String DEFAULT_CATEGORY = "TODO";

    // TODO Include each usage in corresponding Command class
    public static final String ADD_USAGE = "add n/[title] i/[description] t/[hh:mm] "
            + "d/[yyyy-mm-dd] l/[LOCATION] r/[REMINDER] c/[CATEGORY]";
    public static final String DELETE_USAGE = "delete [task number]";
    public static final String FIND_USAGE = "find [pattern]";


    public static final String TAB = "  ";

}
