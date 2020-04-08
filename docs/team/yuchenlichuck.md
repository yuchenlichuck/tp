# Li Yuchen - Project Portfolio



## PROJECT: [CAFS](https://github.com/AY1920S2-CS2113-T14-3/tp/)



## Overview

* [1. CAFS Introduction](#introduction)

* [2. Summary of Contributions](#summary-contribution)
+ [2.1 Code contribution](#code-contribution)
  + [2.2 Enhancements implemented](#enhancement-implemented)
  + [2.3 Contributions to documentation](#contribute-documentation)
  + [2.4 Contributions to the Developer Guide](#contribute-developerguide)
  + [2.5 Contributions to team-based tasks](#contribute-team)
  + [2.6 Review/Mentoring contributions](#review-mentoring)
  + [2.7 Contributions beyond the project team](#contribute-team)
  
* [3. Contributions to the User Guide](#contribute-ug)

* [4. Contributions to the Developer Guide](contribute-dg)

<a name="introduction"></a>

### CAFS Introduction 

Va CLI calender-like task scheduler that supports task and class schedule adding. It is simple to use, and comes with a save function to remember your tasks. The user interacts with the application using a CLI. The project is mainly written in Java.

<a name="summary-contribution"></a>

### Summary of contributions

<a name="code-contribution"></a>

#### Code contribution

You can view my code contribution for this project: [HERE](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#search=yuchenlichuck&sort=groupTitle&sortWithin=title&since=2020-03-01&timeframe=commit&mergegroup=false&groupSelect=groupByRepos&breakdown=false)

- Test Code: AddCommandTest, test if adding is right or out of boundary.
- Refactor: Extract different method's constants into messages class.
- Time and Date Format: Change the time and date format, so that the tool can recognise whether the date or time wrong or right (With Leap year).

<a name="enhancement-implemented"></a>
#### Enhancements implemented


<a name="contribute-documentation"></a>
#### Contributions to documentations:

<a name="contribute-developerguide"></a>
#### Contributions to the DG

#### Contributions to team-based tasks:

<a name="review-mentoring"></a>

#### Review/Mentoring contributions: 

<a name="contribute-team"></a>

#### Contributions beyond the project team:

<a name="contribute-ug"></a>

### Contributions to the User Guide (Extracts)



### List

#### **List** 

List all tasks

* **Usage**: `list`

#### **List Category**

List tasks belong to a specific category

* **Usage**: `list c/<CATEGORY>`
  * Wrong command: `list TODO` which will has the same effects as the `list`
  * The `<CATEGOTY>` is case insensitive. That is, `list c/TODO` and `list c/todo` has same effect.
  * Examples:
    * list c/TODO
    * list c/DEADLINE

#### **List Time** And/Or Date

List tasks by specific date/time

* **Usage**: `list d/<DATE> t/<TIME>`
  * It is okay to list events in a specific date and specific time. However, the class category cannot be shown, since these don't have date values.
  * It is okay to list events just in a specific date. However, the class category cannot be shown, since these don't have date values.
  * It is okay to list events just in a specific time. All categories can be shown
* Example:
  - list d/2020-03-16 t/15:00
   - list d/2020-08-10
  - list t/15:00

#### List Category & Time And/Or Date

List tasks by category and date and time. 

* **Usage**: `list c/<CATEGORY> d/<DATE> t/<TIME>`

  * It is okay to list events in a specific date and specific time in a  specific category. However, the class category cannot be shown, since these don't have date values.
  * It is okay to list events just in a specific date in a specific category. However, the class category cannot be shown, since these don't have date values.
  * It is okay to list events just in a specific time in a specific category. All categories can be shown.
  * Examples: 
    * list d/2020-03-16 t/15:00 c/todo
    * list d/2020-08-10 c/deadline
    * list t/14:00 c/deadline

### Delete

#### **Delete a task**

Delete a task from the list

* **Usage**: `delete <task index>`
  * The index refers to the index number shown in the displayed task list.
  * use `list` to derive task index
  * index has to be a positive_integer_
  * Examples:
    * delete 2

#### **Delete Category**

Delete tasks belong to a specific category

* **Usage**: `delete c/<CATEGORY>`
  * Wrong command: `delete TODO` which is a invalid input
  * The `<CATEGOTY>` is case insensitive. That is, `delete c/TODO` and `dele c/todo` has same effect.
  * Examples:
    * delete c/todo
    * delete c/deadline

#### **Delete Time And/Or Date**

Delete tasks by specific date/time

* **Usage**: `delete d/<DATE> t/<TIME>`
  *  It is okay to delete events in a specific date and specific time. However, the class category cannot be shown, since these don't have date values.
  *  It is okay to delete events just in a specific date. However, the class category cannot be shown, since these don't have date values.
  * It is okay to delete events just in a specific time. All categories can be shown
  * Example:
       * delete d/2020-03-16 t/15:00
       * delete d/2020-08-10
       * delete t/15:00


#### **Delete Category & Time And/Or Date**

List tasks by category and date and time. 

* **Usage**: `delete c/<CATEGORY> d/<DATE> t/<TIME>`
  * It is okay to delete events in a specific date and specific time in a specific category. However, the `class` category cannot be shown, since these don't have date values.
  * It is okay to delete events just in a specific date in a specific category. However, the `class` category cannot be shown, since these don't have date values.
  * It is okay to delete events just in a specific time in a specific category. All categories can be shown.
    * Examples: 
      * delete d/2020-03-16 t/15:00 c/todo
      * delete d/2020-08-10 c/deadline
      * delete t/14:00 c/deadline



### About Me

**Educational experience**

- Undergraduate

- in the department of Computer Science and Engineering

- at Southern University of Science and Technology

- Currently conducting semester exchanges at the National University of Singapore and receiving scholarships for overseas study scholarships

