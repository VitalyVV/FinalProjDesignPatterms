package commands;

import application.ApplicationContext;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class HelpCommand implements Command {

    @Override
    public void execute(String command) {
        Set<Map.Entry<String, Command>> commands = ApplicationContext.getInstance().getCommands();
        for (Map.Entry<String, Command> c: commands) {
            try{
                System.out.println(c.getKey() + " " + c.getValue().description());
            }catch (NullPointerException ignored){ }
        }
    }

    @Override
    public String description() {
        return "Shows this message.";
    }

}
