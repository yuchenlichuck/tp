# User Guide

## 1. Introduction
CAFS - va CLI task scheduler that supports three 
different types of tasks (todo, event and deadline). 
It is simple to use, and comes with a save function to 
remember your tasks.

## 2. Quick Start
1. Ensure you have Java 11 or above installed in your Computer

1. Download the latest cafs.jar

1. Copy the file to the folder you want to use as the home folder.

1. Run the jar file using `java - jar caf.jar`

## 3. Features

### 3.1 - Add
Users add tasks using this command
* **Usage**: `Add  n/<NAME> t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
     * Examples:
        * add t/12:00pm n/UG d/02/18/2020 i/UG deadline r/NUS r/1d
        * add t/15:00 n/Project Meeting  d/01/01/2020   i/Work on awesome features
        * add t/11:00 n/Response Paper  d/2/2/2020 i/Finish essay c/

### 3.2 - List
* Lists all tasks
* **Usage**: `list`

### 3.3 - Delete
* Deletes a task from the list
* **Usage**: `delete <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.4 - Done
* Changes the status of a task to completed
* **Usage**: `done <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.5 - Find
* Searches all task descriptions for supplied keyword
* **Usage**: `find <keyword>`
    * Keyword has to be a _**single word**_
    * Keyword is case _insensitive_

### 3.6 - Help
* displays the set of commands supported
* **Usage**: `help`

### 3.7 - Exit
* Exits the program
* **Usage**: `bye`

## 4. Sample Usage
 
1. Search for specific keyword: `find class`
    * Expected outcome: displays the above two tasks since they contain keyword "class" in description
    
## 5. FAQ
 * How do I save my tasks?
    * Tasks are saved automatically and loaded upon start up of application
    * If unable to load, check the directory and file name
        * Default folder (windows): `C:\Users\<computer name>\Save`
        * Default file name: `data.txt`
 
## 6. Command Summary
 * **Add**: `add n/<NAME> t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
 * **List**: `list` 
 * **Delete**: `delete <task index>` 
 * **Done**: `done <task index>` 
 * **Find**: `find <keyword>` 
 * **Help**: `help`
 * **Exit**: `bye`