package commands.tasks;

public class AddTaskCommand extends TaskCommand {

    @Override
    public String description() {
        return "Add new project: Use add project <name>.\"\n" +
                "Add new task. Use add task <id> <description> <project_name>. " +
                "Leave project name empty if you don't want to assign task to any project.\n" +
                "Add subtask. Use add subtask <parent id> <description>. Parent id should exist.";
    }
}
