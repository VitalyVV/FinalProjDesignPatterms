package commands.tasks;

import application.Application;
import application.ApplicationContext;
import commands.Command;
import mediator.Mediator;
import tasks.Project;

public class AddProjectCommand extends TaskCommand {
    @Override
    public String description() {
        return "Add new project: Use add project <name>.\"";
    }
}
