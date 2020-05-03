package application;

import commands.Command;
import commands.ErrorCommand;
import commands.HelpCommand;
import commands.tasks.*;

import java.io.IOException;
import java.util.HashMap;

public class Application {

    //TODO: parameter error message

    public Application() {
        ApplicationContext context = ApplicationContext.getInstance();
        context.addCommand("add", new AddCommand());
        context.addCommand("show", new ShowCommand());
        context.addCommand("check", new CheckCommand());
        context.addCommand("uncheck", new UncheckCommand());
        context.addCommand("help", new HelpCommand());
        context.addCommand("deadline", new DeadlineCommand());
        context.addCommand("err", new ErrorCommand());
    }

    public void run(){
        while(true){
            ApplicationContext.getInstance().write("> ");
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
        HashMap<String, Command> commands = ApplicationContext.getInstance().getCommands();
        Command c = commands.getOrDefault(params[0], null);

        if (c != null){
            try{
                c.execute(command);
            }catch (ArrayIndexOutOfBoundsException e){
                commands.get("err").execute(command);
            }
        }else{
            commands.get("err").execute(command);
        }
    }

}
