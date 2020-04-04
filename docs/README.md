# User Guide
* [Introduction](#1-introduction)
* [Quick Start](#2-quick-start)
* [Features](#3-features)
  * [Help command](#31---help)
  * [Add tasks](#32---add)
  * [List tasks](#33---list)
  * [Delete tasks](#34---delete)
  * [Having done a task](#35---done)
  * [Find a task](#36---find)
  * [Save tasks](#37---save)
  * [Exit the program](#38---exit)
* [Sample Usage](#4-sample-usage)
* [FAQ](#5-faq)
* [Command Summary](#6-command-summary)

## 1. Introduction
CAFS - va CLI calender-like task scheduler that supports task and 
class schedule adding. It is simple to use, and comes with a save function to 
remember your tasks.

## 2. Quick Start
1. Ensure you have Java 11 or above installed in your Computer

1. Download the latest cafs.jar [here](https://github.com/AY1920S2-CS2113-T14-3/tp/releases)

1. Copy the file to the folder you want to use as the home folder.

1. Run the jar file using `java - jar caf.jar`

1. Link to Developer guide [here](https://github.com/AY1920S2-CS2113-T14-3/tp/blob/master/docs/DeveloperGuide.md)

## 3. Features

### 3.1 - Help
Displays the set of commands supported
* **Usage**: `help`

### 3.2 - Add
Users add tasks using this command
* **Usage**: `add  n/<NAME> t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
     * To add class, just need to specify the category is `CLASS`.
     * When adding normal tasks:
        * add t/12:00pm n/UG d/02/18/2020 i/UG deadline r/NUS r/1d
        * add t/15:00 n/Project Meeting  d/01-01-2020   i/Work on awesome features
        * add t/11:00 n/Response Paper  d/02-02-2020 i/Finish essay c/TODO
     * When adding class, the time `t/` becomes time zone of the class (e.g. `12:00-1:00`), and the date
       `d/` becomes which day in a week, represented by integer (e.g. `1 3` means Mon Wed).
       Since a class normally has multiple time zone in a week, student can just add list of time zone.
       However, the number of `t/`should match with the number of `d/` and the number of location. 
        * add t/11:00-12:00 1:00-3:00 n/2113 d/3 4 c/CLASS l/COM2 COM1
        * add n/3245 t/17:00-19:00 d/5 c/CLASS
    
### 3.3 - List
#### 3.3.1 - List 
Lists all tasks
* **Usage**: `list`

#### 3.3.2 - List Category
Lists tasks belong to a specific category
* **Usage**: `list c/<CATEGORY>`
    * Examples:
        * list TODO
        * list DEADLINE
      
#### 3.3.3 - List Time
Lists tasks by specific date/time
* **Usage**: `list d/<DATE> t/<TIME>`
    * It is okay to only list event in a specific date. However, it is not okay to list event in a specific time
        without inferring the specific date. 
    * This will also display the classed whose time range overlaps that time.
    * Also, current does not accept list class. 
    * Examples: 
        * list d/2020-03-16 t/15:00
        * list d/2020-08-10

### 3.3.4 - List specific event
List tasks by category and date and time. 
* **Usage**: `list c/<CATEGORY> d/<DATE> t/<TIME>`


### 3.4 - Delete
Deletes a task from the list
* **Usage**: `delete <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.5 - Done
Changes the status of a task to completed
* **Usage**: `done <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.6 - Find
Searches all task descriptions for supplied keyword
* **Usage**: `find <keyword>`
    * Keyword has to be a _**single word**_
    * Keyword is case _insensitive_

### 3.7 - Save
Exports my calendar as a text file	
* **Usage**: `save`

### 3.8 - Calendar
Prints a monthy representation of a calendar. Shows the number of tasks a user has on a particular day.
Users are able to specify which month to look up. Default is the current month. 

Will still display tasks from past months as long as not marked as complete.
* **Usage**: `calendar <optional month>` 
    * Month is in integer representation
    * Where 1 is January and 12 is December
    * Default set to current month
    * If number supplied is not within the month range, it will be set to current month

### 3.9 - Exit
Exits the program
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
 * **List**: 
    * `list`
    * `list c/<category>` 
    * `list d/<DATE> t/<TIME>`
    * `list c/<category> d/<DATE> t/<TIME>`
 * **Delete**:
    * `delete <task index>` 
 * **Done**: `done <task index>` 
 * **Find**: `find <keyword>` 
 * **Save**: `save`
 * **Help**: `help`
 * **Calendar**: `calendar` or `calendar <month>`
 * **Exit**: `bye`