# User Guide
* [Introduction](#1-introduction)
* [Quick Start](#2-quick-start)
* [Features](#3-features)
  * [Help command](#31---help)
  * [Add tasks](#32---add)
  * [Edit tasks](#33---edit)
  * [List tasks](#34---list)
  * [Delete tasks](#35---delete)
  * [Having done a task](#36---done)
  * [Find a task](#37---find)
  * [Save tasks](#38---save)
  * [Calendar](#39---calendar)
  * [Exit the program](#310---exit)
* [FAQ](#4-faq)
* [Command Summary](#5-command-summary)

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
* `<NAME>` such format indicates user input variable. However, when inputting, there is no need to input `<>`symbol. 
The `<>` symbol just for readability. 
* The command keyword (e.g. `add`) is case insensitive. However, the delimiter (e.g. `n/`)are case sensitive.
* It is okay to switch the sequence when inputting the delimiters:
    * `add n/<NAME> l/<LOCATION>` has same effects as `add l/<LOCATION> n/<NAME> `
* Some recognized date/time error will be automatically parsed to accepted format.
    * `24:00` will be parsed to `23:59` since 24:00 is next day. 
    * `2021-02-30` will be parsed to `2021-02-28`

### 3.1 - Help
Displays the set of commands supported
* **Usage**: `help`

### 3.2 - Add
Users add tasks using this command
* **Usage**: `add  n/<NAME> t/<TIME> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
     * The `<TIME>` should be in time duration format: `hh:mm-hh:mm` (e.g. `11:00-12:00`)
       There should be no space between this duration. 
     * Only name `<NAME>` is compulsory to include. Other fields are not compulsory to add. However, if
       user only inputs time, then date of current day will be automatically added. 
     * Since a task/class may has multiple time zone in a week, student can just add list of time zone.
       However, the number of `<TIME>`should match with the number of `<DATE>`. It is suggested that 
       the number of `<LOCATION>` also match with the number of `<TIME>`. Use space to separate the time 
       zone/date/location.
     * If there is only one time slots for this task, then the `<LOCATION>` will not be separated by space.  
     * The default category is TODO. When adding class, just indicate category is `CLASS`. The category is
       case-insensitive.  
     * When adding normal tasks:
        * `<Date>` should be in format:`yyyy-mm-dd`
        * Examples: 
            * add n/Project Meeting t/12:00-13:00 15:00-16:00 d/2020-07-01 2020-09-01 l/NUS NTU c/meeting
            * add n/2113 v2.1 t/23:00-24:00 d/2020-05-16 c/deadline
            * add n/Project Meeting t/12:00-13:00 15:00-16:00 d/2020-10-01 2020-10-04 l/NUS NTU c/MEETING
     * When adding class:
        * `<DATE>` should be which day in a week, represented by integer (e.g. `1 3` means Mon Wed). 
        * Examples: 
            * add t/11:00-12:00 01:00-03:00 n/2113 d/3 4 c/CLASS l/COM2 COM1
            * add n/3245 t/17:00-19:00 d/5 c/CLASS
    
### 3.3 - Edit
Edit the inputted task/class. 
* **Usage**:`edit TASKINDEX t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
    * It is not allowed to edit the `<NAME>`.
    * It is okay to edit the `<CATEGORY>`. However, it is not allowed to cast from class category to other 
      category. Also, it is not allowed to cast from other category to class. 
    * When edit `<TIME>` and `<DATE>`, please be reminded that the number of `<TIME>`should match with the 
      number of `<DATE>` and the number of location `<LOCATION>`. 
    * Examples: 
        * edit 1 t/11:00-12:00
        * edit 2 c/todo  
    
### 3.4 - List
#### 3.4.1 - List 
Lists all tasks
* **Usage**: `list`

#### 3.4.2 - List Category
Lists tasks belong to a specific category
* **Usage**: `list c/<CATEGORY>`
    * Examples:
        * list c/TODO
        * list c/DEADLINE
        * Wrong command: `list TODO` which will has the same effects as the `list`
        * The `<CATEGOTY>` is case insensitive. That is, `list c/TODO` and `list c/todo` has same effect.
      
#### 3.4.3 - List Time
Lists tasks by specific date/time
* **Usage**: `list d/<DATE> t/<TIME>`
    * It is okay to only list event in a specific date. However, it is not okay to list event in a specific time
        without inferring the specific date. 
    * This will also display the classed whose time range overlaps that time.
    * Also, current does not accept list class. 
    * Examples: 
        * list d/2020-03-16 t/15:00
        * list d/2020-08-10

### 3.4.4 - List specific event
List tasks by category and date and time. 
* **Usage**: `list c/<CATEGORY> d/<DATE> t/<TIME>`


### 3.5 - Delete
Deletes a task from the list
* **Usage**: `delete <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.6 - Done
Changes the status of a task to completed
* **Usage**: `done <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_

### 3.7 - Find
Searches all task descriptions for supplied keyword
* **Usage**: `find <keyword>`
    * Keyword has to be a _**single word**_
    * Keyword is case _insensitive_
    * Find command can search the keyword in title, description and location. 

### 3.8 - Save
Saves current list into somewhere.
* **Usage**: `save`

### 3.9 - Calendar
Prints a monthy representation of a calendar. Shows the number of tasks a user has on a particular day.
Users are able to specify which month to look up. Default is the current month. 

Will still display tasks from past months as long as not marked as complete.
* **Usage**: `calendar <optional month>` 
    * Month is in integer representation
    * Where 1 is January and 12 is December
    * Default set to current month
    * If number supplied is not within the month range, it will be set to current month

### 3.10 - Exit
Exits the program
* **Usage**: `bye`
    
## 4. FAQ
 * How do I save my tasks?
    * Tasks are saved automatically and loaded upon start up of application
    * If unable to load, check the directory and file name
        * Default folder (windows): `C:\Users\<computer name>\Save`
        * Default file name: `data.txt`
 
## 5. Command Summary
 * **Add**: `add n/<NAME> t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
 * **Edit**: `edit TASKINDEX t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
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