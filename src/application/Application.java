package application;

import commands.*;

import java.io.IOException;
import java.util.Map;

public class Application {

    public Application() {
        ApplicationContext context = ApplicationContext.getInstance();
        context.addCommand("help", new HelpCommand());
        context.addCommand("err", new ErrorCommand());
        context.addCommand("add", new AddTaskCommand());
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
