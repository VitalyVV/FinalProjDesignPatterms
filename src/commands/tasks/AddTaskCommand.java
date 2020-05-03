package commands.tasks;

import application.ApplicationContext;
import commands.Command;
import tasks.Project;
import tasks.Task;

public class AddTaskCommand implements Command {
    @Override
    public void execute(String command) {
        ApplicationContext.getInstance().getMediator().notify(this, command);
    }

    @Override
    public String description() {
        return "Add new project: Use add project <name>.\"\n" +
                "Add new task. Use add task <id> <description> <project_name>. " +
                "Leave project name empty if you don't want to assign task to any project." +
                "Add sub task.";
    }
}
