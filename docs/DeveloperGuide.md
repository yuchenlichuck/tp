# Developer Guide
* [Setting up](#1-setting-up)
* [Design](#2-design)
* [Implementation](#3-implementation)
  * [Undo features](#31-proposed-features)
    * [List By Category](#311-list-by-category)
    * [Calendar](#312-proposed-view-month)
* [Documentation](#4-documentation)
* [Testing](#5-testing)
* [Dev Ops](#6-dev-ops)
  * [Appendix A: Product Scope](#61-appendix-aproduct-scope)
  * [Appendix B:Value proposition](#62-appendix-bvalue-proposition)
  * [Appendix C:User Stories](#63-appendix-cuser-stories)
  * [Appendix D:Non-Functional Requirements](#64-appendix-dnon-functional-requirements)
  * [Appendix E:Glossary](#65-appendix-eglossary)
  * [Appendix F:Instructions for Manual Testing](#66-appendix-finstructions-for-manual-testing)
## 1. Setting up
## 2. Design

{Describe the design of the product. Use **Architecture Diagram** which has not been covered yet.}

## 3. Implementation
### 3.1 [Proposed] Features
#### 3.1.1 List By Category
##### 3.1.1.1 Proposed Implementation
The list by category mechanism is facilitated by ListCommand which extends Command.

Given below is an example usage scenario and how the mechanism behaves at each step.

Step1: The user adds a task:  `add n/2113 c/DEADLINE d/2020-03-30 t/11:59` to add a task.
Since the user adds a new category `DEADLINE`, the categoryMap wil add one more key whose value is the category and the value is
the index for this task.

Step2: The users adds a task: `add n/3145 c/CLASS` to add a class. 
Since the user adds a new category `CLASS`, the categoryMap wil add one more key whose value is the category and the value is
the index for this task.

Step3: Users list the class he just added by category CLASS: `list c/CLASS`. The TaskList will
return the index of the tasks based on the categoryMap. Then the task in the `CLASS` category
will be displayed. 

This is the Sequence Diagram for list by category. 
![Sequence Diagram for View](images/listCategorySequence.png)

This is the UML design for list by category.

![UML for View](images/listCategory.png)

##### 3.1.1.2 Design Considerations
Aspect: How to find certain category. 

Alternative 1 (previous choice): store HashMap to map category with the key. The map still exists which
stores the needed categories. 

Alternative 2 (current choice): linear search when searching tasks. 


#### 3.1.2 [Proposed] View month
##### 3.1.2.1 Proposed Implementation
The view month mechanism is facilitated by CalendarCommand which extends Command.

Given below is an example usage scenario and how the mechanism behaves at each step.

1. The user inputs the command word `calendar`. Upon which, the instance of parser will return a CalendarCommand for execution
1. CalendarCommand initialises with the following variables, with the help from a calendar class containing the necessary methods related to day/date.
    * month - if user does not input month, it uses computer's current month
    * startingDay - which day of the week the first day of the months begins on (0-6, where 0 is Monday)
    * totalDays - how many days in that month
    * totalWeeks - number of weeks of the month
  
1. The `calendar` command calls on TaskList#findTaskDate() for each day of the month to generate the task listing for a particular day. Only the task event and description is added to calendar view. 
1. The calendar generated is then stored in a string and UI#showUserMesssage() is called to display the calendar. 

The class diagram below shows the relationships between the different classes required by the `calendar` feature.
![Sequence diagram for CalendarCommand](images/CalendarCommand_class.jpg)


The following diagram summarises what happens when a user executes a new `calendar` command:
![Sequence diagram for CalendarCommand](images/CalendarCommand_sequence.jpg)


##### 3.1.2.2 Design Considerations
1. Aspect: Obtaining information required for generating monthly view
  
    * Alternative 1: (current choice) Algorithm to deduce how many weeks in month, which day a date is, how many days in that month
        * Pros: Will use less memory, requiring only one starting date we are able to derive any other dates. No need to worry about changing template for the new year
        * Cons: New developers will take additional effort to understand how the algorithm works.
      
    * Alternative 2: Hardcoded information (constant variables to tell days in month/how many weeks)
        * Pros: Easy maintenance, tedious but easily calculated with web applications.
        * Cons: Tedious and not sustainable, constant updates have to be done to edit the fields for a new year

1. Aspect: Which month to use
  
    * User might want to know schedule for other months, but might also want a quick view of current month
    * Solution is to set a default month (taken from computer) and also allow input for preferred month.

1. Aspect: generation of monthly details 
  
    * Calculation of details are shifted from the command to a separate class. 
    This is to enable easier maintenance for methods relating to calendar features.
    
## 4. Documentation

## 5. Testing
There are two ways to do the test.
Method 1: Using IntelliJ JUnit test runner
To run all tests, right-click on the src/test/java folder and choose Run `All Tests`
To run a subset of tests, you can right-click on a test package, test class, or a test and choose Run  `ABC`

Method 2: Using Gradle
Open a console and run the command gradlew clean test (Mac/Linux: ./gradlew clean test)
## 6. Dev Ops
### 6.1 Appendix A:Product Scope
Target User profile:
1. University students.
2. Prefer desktop apps.
3. Can type fast

### 6.2 Appendix B:Value proposition
It solves:
1. Daily tasks arrangement
2. Class schedule arrangement
3. Event alert

## 6.3 Appendix C:User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|No 1. is any type of student [epic] (3)   | add events to my calendar | I know what I have to do in the upcoming weeks |
|v1.0|                                          | add the location where events take place | I know where I have to go |
|v1.0|                                          | add club, research, project, or other meetings | Be reminded of my activities |
|v1.0|No 2. is a university student | delete specific events from my calendar | I don't get reminded about events that already happened |
|v1.0|No 3. is a university student | can move events from one day to another | Will not need to  retype all the event details again |
|v1.0|No 5. is a university student | add descriptions to events | to remind myself what the event was about |
|v2.0| No 4. is a university student | see multiple calendar views (day, week, month) | I can get different perspectives of what my schedule looks like |
|v2.0| No 9. is a university student | export my calendar as a text file | I can print it to have a physical copy |
|v2.0| No 10. is a university student | remove all the events that happened in a specific date range | it's easy to delete unnecessary details from my calendar |
|v2.0| No 11. is a university student | add my student schedule | quickly reference it when I forget my next class |
|v2.1| No. 23 is a university student | list events by category | I can easily find exactly the events I need to see |
|v2.1| No. 6 is a student who cares about friendship | add tokens to specific days in my calendar | I can remember special occasions such as birthdays, religious events, etc. |
|v2.1| No. 20 is a university student who has frequent project meetings in school | compare my schedule with team mates easily | we can quickly find a common time to work |
|v2.1| No. 21 is a university student | list events by date | I can easily find exactly the events I need to see by date |
|v2.1| No. 24 is a university student who want to check whether a designated time has events | list events by time | I can easily find exactly the events I need to see by time |
|v2.1| No. 25 is a university student who want to check whether a designated time has classes | list events by time and category | I can easily find exactly the classes I need to see by time and category |
|v2.1| No. 22 is a university student who has some emergency and want to cancel the events in a specific date | delete events by date | I can easily delete exactly the events I need to see by date |
|v2.1| No. 26 is a male student who want to quit events in a designated time cause he has a remote date with his remote girlfriends in that time everday! | delete events by time | I can easily find exactly the events I need to see by time |
|v2.1| No. 27 is a university student who want to delete its todo category's events cause it doesn't want to work hard anymore that day | delete events by time and category | I can easily find exactly the events I need to see by date and category |
|v2.1| No. 28 is a university student who has a emergency in specfic time and date. He wants to delete that time's work | Delete events by date and time | I can easily find exactly the events I need to see by date and time |

## 6.4 Appendix D:Non-Functional Requirements

1. Should work in an environment without internet access.
1. Should offer easy / experienced user input modes to accommodate to different proficiencies
1. Data should be persistent across different start-ups
1. Not too restrictive on user to avoid frustrations (user friendly)

## 6.5 Appendix E:Glossary

* *glossary item* - Definition

## 6.6 Appendix F:Instructions for Manual Testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
