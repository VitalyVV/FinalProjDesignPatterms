package application;

import commands.Command;
import commands.ErrorCommand;
import commands.HelpCommand;
import commands.tasks.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Application implements Runnable{

    public Application(BufferedReader in, PrintWriter out) {
        ApplicationContext context = ApplicationContext.getInstance();
        context.setIn(in);
        context.setOut(out);
        context.addCommand("add", new AddCommand());
        context.addCommand("show", new ShowCommand());
        context.addCommand("check", new CheckCommand());
        context.addCommand("uncheck", new UncheckCommand());
        context.addCommand("deadline", new DeadlineCommand());
        context.addCommand("remove", new RemoveCommand());
        context.addCommand("help", new HelpCommand());
        context.addCommand("today", new TodayCommand());
    }

    @Override
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
            c.execute(command);
        }else{
            new ErrorCommand().execute(command);;
        }
    }

}
