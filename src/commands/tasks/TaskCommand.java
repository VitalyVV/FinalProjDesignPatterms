package commands.tasks;

import application.ApplicationContext;
import commands.Command;
import exceptions.NoTaskProjectException;
import exceptions.ParametersException;

public abstract class TaskCommand implements Command {
    @Override
    public void execute(String command) {
        try {
            ApplicationContext.getInstance().getMediator().notify(this, command);
        }catch (ParametersException | NoTaskProjectException e){
            ApplicationContext.getInstance().writeln(e.getMessage());
        }
    }

}
