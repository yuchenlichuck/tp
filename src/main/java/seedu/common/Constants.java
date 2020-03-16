package seedu.common;

public final class Constants {

    public static final char TASK_TODO = 'T';
    public static final char TASK_EVENT = 'E';
    public static final char TASK_DEADLINE = 'D';
    public static final int DEADLINE_LENGTH = 8;
    public static final int EVENT_LENGTH = 5;


    // TODO Can be refactored into Command classes
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String TODO = "todo";
    public static final String LIST = "list";
    public static final String HELP = "help";
    public static final String EXIT = "bye";
    public static final String DONE = "done";
    public static final String FIND = "find";
    public static final String DELETE = "delete";
    public static final String EDIT = "edit";
    public static final String CLEAR = "clc";


    public static final String DEADLINE_USAGE = "deadline n/[title] d/[date] i/[description]";
    public static final String EVENT_USAGE = "event n/[title] d/[date] i/[description]";
    public static final String TODO_USAGE = "todo n/[title] i/[description]";
    public static final String DELETE_USAGE = "delete [task number]";
    public static final String FIND_USAGE = "find [pattern]";

}
