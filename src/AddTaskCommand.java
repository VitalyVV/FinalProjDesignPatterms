public class AddTaskCommand implements Command{
    @Override
    public void execute(String command) {
        String[] commands = command.split(" ");
        long id = Long.parseLong(commands[2]);
        String description = commands[3];
        String projectName = commands.length>4 ? commands[3] : "";
        Task task = new Task(id, description, false);
        Project project = ApplicationContext.getInstance().getProjectByName(projectName);

        ApplicationContext.getInstance().getMediator().addTask(task, project);
    }

    @Override
    public String description() {
        return "Add new task. Use add task <id> <description> <project_name>. " +
                "Leave project name empty if you don't want to assign task to any project.";
    }
}
