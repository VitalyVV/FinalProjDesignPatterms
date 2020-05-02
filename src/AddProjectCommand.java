public class AddProjectCommand implements Command {
    private Mediator projectsMediator;

    public AddProjectCommand(Mediator projectsMediator) {
        this.projectsMediator = projectsMediator;
    }

    @Override
    public void execute(String command) {
        String[] commandParts = command.split(" ");
        String name = commandParts[2];
        String date = "";
        if (commandParts.length>3){
            date = String.join(" ", new String[]{commandParts[3], commandParts[4], commandParts[5]});
        }
        Project project = new Project(name,projectsMediator)
                .addDeadline(date);

        ApplicationContext.getInstance().addProject(project);
    }

    @Override
    public String description() {
        return "Add new project: Use add project <name>.\"";
    }
}
