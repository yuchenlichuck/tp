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
  * [Calendar](#38---calendar)
  * [Clear Command](#39---clear)
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
* When inputting a time, the time format is always: `hh:mm`.
  Most command accepts time range which is: `hh:mm-hh:mm`. No space is allowed around `-`.
  Also, similar format like `1:00` will not be allowed. 
* When inputting a date, the date format is always: `yyyy-mm-dd`.
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
     * Since a task/class may have multiple time ranges in a week, the student can just add list of time ranges.
       However, the number of `<TIME>`should match with the number of `<DATE>`. It is suggested that 
       the number of `<LOCATION>` also match with the number of `<TIME>`. Use space to separate the *time range/date/location*.
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
#### **3.4.1 - List** 
List all tasks
* **Usage**: `list`

#### **3.4.2 - List Category**
List tasks belong to a specific category
* **Usage**: `list c/<CATEGORY>`
    * Wrong command: `list TODO` which will has the same effects as the `list`
    * The `<CATEGOTY>` is case insensitive. That is, `list c/TODO` and `list c/todo` has same effect.
    * Examples:
        * `list c/TODO`
        * `list c/DEADLINE`

#### 3.4.3 - List Time
Lists tasks and classes by specific time range. 
* **Usage**: `list t/<TIME>`
    * `task` and `class` with a specific time range can be listed by `list t/hh:mm-hh:mm`.
    List the `events` which are exactly at that time range or have a overlap at that time range.
      * `list t/15:00-16:00`
      * *(Explanation: list the `events` whose start time before `16:00` and end time after `15:00`)*

#### 3.4.4 - List Date
List tasks by specific date.
* **Usage** : `list d/<DATE>`
  
    * `task` with a specific date can be listed by `list d/yyyy-mm-dd`. Or `tasks` have date/dates in the specific dates can be listed by  `list d/yyyy-mm-dd yyyy-mm-dd ...` *(more dates)*.
    * `class` cannot be listed by date since class only adopts schedule.
        * `list d/2020-06-17`
        * *(Explanation: list the `tasks` which have date on `2020-06-17`  )*
        * `list d/2020-06-17 d/2020-06-19`
        * *(Explanation: list the `tasks` which have date on `2020-06-17` or `2020-06-19` )*
    
#### 3.4.5 - list Date + Time        
List tasks by specific date and time.
* **Usage** : `list d/<DATE> t/<TIME>`
  
    * `task` with a specific date and time range can be listed by `list d/yyyy-mm-dd t/hh:mm-hh:mm`
      
    * class` cannot be listed by date and time since class only adopts schedule. 
      
       List the `tasks` which are exactly at that time range or have a overlap at that time range.
       
        * `list d/2020-06-17 t/12:00-13:00`
        * *(Explanation: list the `tasks` whose start time before `2020-06-17 13:00` and end time after `2020-06-17 12:00`)*
       
#### 3.4.6 - List specific event

List tasks by category and date and time. 
* **Usage**: `list c/<CATEGORY> d/<DATE> t/<TIME>`
* It is okay to list `events` in a specific date and specific time range in a  specific category. However, the `class` category cannot be shown, since these don't have date values.
    * It is okay to list `events` just in a specific date/dates in a specific category. However, the `class` category cannot be shown, since these don't have date values.
    * It is okay to list `events` just in a specific time range in a specific category. All `categories` can be shown.
        * `list d/2020-06-17 t/12:00-13:00 c/todo`
        * *(Explanation: list the `tasks` whose start time before `2020-06-17 13:00` and end time after `2020-06-17 12:00` and  category is `todo` )*
        * `list d/2020-08-10 c/deadline`
        * *(Explanation: list the `tasks` which have date on `2020-08-10` and whose `category` is `deadline`)*
        * `list t/14:00-15:00 c/deadline`
        * *(Explanation: list the `tasks` whose start time before `15:00` and end time after `14:00`and `category` is `deadline` )*

### 3.5 - Delete
Deletes a task from the list
#### 3.5.1 - Delete a task/class
* **Usage**: `delete <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_
      
#### 3.5.2 - Delete Time
Delete tasks and classes by specific time range. 
* **Usage**: `delete t/<TIME>`
    * `task` and `class` with a specific time range can be listed by `delete t/hh:mm-hh:mm`.
    Delete the `events` which are exactly at that time range or have a overlap at that time range. 
      * `delete t/15:00-16:00`
      * *(Explanation: delete the `events` whose start time before `16:00` and end time after `15:00`)*

#### 3.5.3 - Delete Date
Delete tasks by specific date.
* **Usage** : `delete d/<DATE>`
    * `task` with a specific date can be listed by `delete d/yyyy-mm-dd`. Or `tasks` have date/dates in the specific dates can be listed by  `delete d/yyyy-mm-dd yyyy-mm-dd ...` *(more dates)*.
       `class` cannot be listed by date since class only adopts schedule
     * `delete d/2020-06-17`
       * *(Explanation: list the `tasks` which have date on `2020-06-17`  )*
       * `delete d/2020-06-17 d/2020-06-19`
       * *(Explanation: list the `tasks` which have date on `2020-06-17` or `2020-06-19` )*
       
#### 3.5.4 - Delete Date + Time        
Delete tasks by specific date and time.
* **Usage** : `delete d/<DATE> t/<TIME>`
    * `task` with a specific date and time can be listed by `delete d/yyyy-mm-dd t/hh:mm-hh:mm`
       `class` cannot be listed by date and time since class only adopts schedule. 
    * Delete the `tasks` which are exactly at that time range or have a overlap at that time range.
    
        * `delete d/2020-06-17 t/12:00-13:00`
        * *(Explanation: delete the `tasks` whose start time before `2020-06-17 13:00` and end time after `2020-06-17 12:00`)*
### 3.6 - Done
Change the status of a task to completed
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

### 3.8 - Calendar
Prints a monthly representation of a calendar. Shows the number of tasks a user has on a particular day.
Users are able to specify which month to look up. Default is the current month. 

Will still display tasks from past months as long as not marked as complete.
* **Usage**: `calendar <optional month>` 
    * Month is in integer representation
    * Where 1 is January and 12 is December
    * Default set to current month
    * If number supplied is not within the month range, it will be set to current month

### 3.9 - Clear
Clear the Command
* **Usage**:`clc`

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
    * `list t/<TIME>`
    * `list d/<DATE>`
    * `list d/<DATE> t/<TIME>`
    * `list c/<CATEGORY> d/<DATE> t/<TIME>`
 * **Delete**:
    * `delete <task index>` 
    * `delete t/<TIME>` 
    * `delete d/<DATE>`
    * `delete d/<DATE> t/<TIME>`
    * `delete c/<CATEGORY> d/<DATE> t/<TIME>`
 * **Done**: `done <task index>` 
 * **Find**: `find <keyword>` 
 * **Save**: `save`
 * **Help**: `help`
 * **Calendar**: `calendar` or `calendar <month>`
 * **Clear**:`clc`
 * **Exit**: `bye`