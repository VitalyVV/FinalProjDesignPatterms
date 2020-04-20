# Promject


## Refamctoring the code

1. Refactor class Task for a composition;
1. Put input output into a Context;
2. Command pattern for Action;
4. Fabric for Projects;

## Add functionality support
1. Deadlines;
  * Each task can have a "deadline" (command example: deadline <ID> <date>).
  * The `today` command will allow you to see all the tasks whose deadline is today.
2. Removal
  * Allow the user to delete tasks (command example: delete <ID>).
3. Visualizations
  * View the tasks by date (command example: view by date).
  * View tasks by deadline (command example: view by deadline).
  * Without changing the functionality that allows a user to see tasks by project, change the command to view by project.

4. Allow a task to "belong" to several projects at the same time (if checked in one, checked in all for example)
4. Ensure that the application permanently maintains 2 task lists per project: the "checked" and the "unchecked"
4. (Be careful this one is tricky) Make sure that a task can be itself a task list