# Developer Guide
* [Setting up](#1-setting-up)
* [Design](#2-design)
* [Implementation](#3-implementation)
  * [Undo features](#31-proposed-undo-feature)
    * [View By Category](#311-view-by-category)
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
### 3.1 [Proposed] Undo Feature
#### 3.1.1 View By Category
It extends the current view command.
The user can use `view` to view all tasks.
The user can also use `view CATEGORY` to view specific classes whose category is sth. 
This is the UML design for view by category.
![UML for View](images/viewCategory.png)

<p>
Step1: Users add task and add either a default category/new category.
If user adds default category, then the categoryMap in taskList will not be modified.
If the user adds a new category, the categoryMap wil add one more key whose value is the category and the value is
the index for this task.
</p>


Step2:  User view tasks by category.
If user only type in `view`, then all tasks will be displayed according to the sequence of task
index. It simply calls the view function.
If user type in in `view CATEGORY`, and the category is valid, then it will go for the
returnCategory method.
If user type in in `view CATEGORY`, and the category is invalid, then it will go for the
displayCategory method. 
Whatever the path, the UI will finally be called either display tasks given the index or display
category. 


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
|v2.0| No. 6 is a student who cares about friendship | add tokens to specific days in my calendar | I can remember special occasions such as birthdays, religious events, etc. |
|v2.0| No 9. is a university student | export my calendar as a text file | I can print it to have a physical copy |
|v2.0| No 10. is a university student | remove all the events that happened in a specific date range | it's easy to delete unnecessary details from my calendar |
|v2.0| No 11. is a university student | add my student schedule | quickly reference it when I forget my next class |
|v2.0| No. 20 is a university student who has frequent project meetings in school | compare my schedule with team mates easily | we can quickly find a common time to work |
|v2.0| No. 23 is a university student | view events by category | I can easily find exactly the events I need to see |
|v2.0| No. 24 is a university student | view events by date | I can easily find exactly the events I need to see |

## 6.4 Appendix D:Non-Functional Requirements

1. Should work in an environment without internet access.
1. Should offer easy / experienced user input modes to accommodate to different proficiencies
1. Data should be persistent across different start-ups
1. Not too restrictive on user to avoid frustrations (user friendly)

## 6.5 Appendix E:Glossary

* *glossary item* - Definition

## 6.6 Appendix F:Instructions for Manual Testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
