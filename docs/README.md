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
  * [View tasks in calender](#37---view)
  * [Save tasks](#38---save)
  * [Add class](#39---class)
  * [Exit the program](#310---exit)
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

## 3. Features

### 3.1 - Help
Displays the set of commands supported
* **Usage**: `help`

### 3.2 - Add
Users add tasks using this command
* **Usage**: `add  n/<NAME> t/<Time> l/<LOCATION> d/<DATE> i/<INFORMATION> r/<REMINDER> c/<CATEGORY>`
     * Examples:
        * add t/12:00pm n/UG d/02/18/2020 i/UG deadline r/NUS r/1d
        * add t/15:00 n/Project Meeting  d/01/01/2020   i/Work on awesome features
        * add t/11:00 n/Response Paper  d/2/2/2020 i/Finish essay c/TODO

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
    * Examples: 
        * list d/2020-03-16 t/15:00
        * list d/2020-08-10

### 3.3.4 - List specific event
List tasks by category and date and time. 
* **Usage**: `list c/<CATEGORY> d/<DATE> t/<TIME>`


### 3.4 - Delete
#### 3.4.1 - Delete A task
Deletes a task from the list
* **Usage**: `delete <task index>`
    * The index refers to the index number shown in the displayed task list.
    * use `list` to derive task index
    * index has to be an _integer_
    
#### 3.4.2 - Delete Task within Range
Delete tasks within time range
* **Usage**: `delete s/<START DATE> e/<END DATE>`
    * The `START DATE/END DATE` should be in correct date format: yyyy-mm-dd
    * Example:
        * delete s/2020-03-16 e/2020-04-15
        

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

### 3.7 - View
Displays a calender based on day/week/month
* **Usage**: `view <DAY/WEEK/MONTH>`

### 3.8 - Save
Exports my calendar as a text file	
* **Usage**: `save`

### 3.9 - Class
Add my student schedule which will be repetitive added for a specific range of time
* **Usage**: `class n/<NAME> d/<DATE> r/<REPEAT WEEKS> i/<INFORMATION>`
    * The `DATE` should be MON/TUE/WED/THU/FRI. User can input more than one DATE
    * The `REPEAT WEEKS` should be an integer: how long do you have this class in the following weeks
    * After you input this command, the system will generate prompt to ask specific time 
        and location of each class
    * Then you input: `s/<START TIME> e/<END TIME> l/<LOCATION>`
    * Examples:
        * class n/2113 d/TUE WED r/13 l/NUS COM2 i/Attendance compulsory
          
          _Then system will generate:`Time and Location for TUE:`_
          
          s/14:00 e/15:00 l/COM2 01-07
          
          _Then system will generate:`Time and Location for WED:`_
          
          s/10:00 e/12:00

### 3.10 - Exit
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
    * `delete s/<START DATE> e/<END DATE>`
 * **Done**: `done <task index>` 
 * **Find**: `find <keyword>` 
 * **View**: `view <WEEK/DAY/MONTH>`
 * **Save**: `save`
 * **Class**: 
    * `class n/<NAME> d/<DATE> r/<REPEAT WEEKS> i/<INFORMATION>`
    * `s/<START TIME> e/<END TIME> l/<LOCATION>`
 * **Help**: `help`
 * **Exit**: `bye`