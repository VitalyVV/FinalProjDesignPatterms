package commands;

import application.Application;
import application.ApplicationContext;
import mediator.Mediator;
import tasks.Project;

public class AddProjectCommand implements Command {

    @Override
    public void execute(String command) {
        ApplicationContext.getInstance().getMediator().notify(this, command);
    }

    @Override
    public String description() {
        return "Add new project: Use add project <name>.\"";
    }
}
