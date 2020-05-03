package commands.tasks;

import application.ApplicationContext;
import commands.Command;

public abstract class TaskCommand implements Command {
    @Override
    public void execute(String command) {
        ApplicationContext.getInstance().getMediator().notify(this, command);
    }

}
