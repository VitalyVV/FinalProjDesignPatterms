package application;

import commands.*;
import commands.ErrorCommand;
import commands.HelpCommand;
import commands.tasks.*;

import java.io.IOException;
import java.util.Map;

public class Application {

    //TODO: check
    //TODO: uncheck
    //TODO: deadlines
    //TODO: removal
    //TODO: fix descriptions
    //TODO: parameter error message
    //TODO: not found message
    //TODO: id-task output

    public Application() {
        ApplicationContext context = ApplicationContext.getInstance();
        context.addCommand("add", new AddCommand());
        context.addCommand("show", new ShowCommand());
        context.addCommand("check", new CheckCommand());
        context.addCommand("uncheck", new UncheckCommand());
        context.addCommand("help", new HelpCommand());

        //Todo something with err command
        context.addCommand("err", new ErrorCommand());
    }

    public void run(){
        while(true){
            ApplicationContext.getInstance().getOut().print("> ");
            ApplicationContext.getInstance().getOut().flush();
            String command;
            try {
                command = ApplicationContext.getInstance().getIn().readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals("quit")) {
                break;
            }else router(command);
        }
    }

    private void router(String command){
        String[] params = command.split(" ", 2);
        Command error = null;

        for(Map.Entry<String, Command> c: ApplicationContext.getInstance().getCommands()){
            if(c.getKey().equals(params[0])) {
                c.getValue().execute(command);
                return;
            }
            if(c.getKey().equals("err")) error = c.getValue();
        }
        if(error != null)
            error.execute(command);
    }

}
