import java.util.ArrayList;

public class HelpCommand implements Command {

    @Override
    public void execute(String command) {
        ArrayList<Command> commands = ApplicationContext.getInstance().getCommands();
        for (Command c: commands) {
            try{
                System.out.println(c.description());
            }catch (NullPointerException np){
                continue;
            }
        }
    }

    @Override
    public String description() {
        return "Shows this message.";
    }

}
