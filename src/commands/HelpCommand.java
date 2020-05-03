package commands;

import application.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {

    @Override
    public void execute(String command) {
        HashMap<String, Command> commands = ApplicationContext.getInstance().getCommands();
        for (Map.Entry<String, Command> c: commands.entrySet()) {
            try{
                System.out.println(c.getKey() + ": " + c.getValue().description());
            }catch (NullPointerException ignored){ }
        }
    }

    @Override
    public String description() {
        return "Shows this message.";
    }

}
