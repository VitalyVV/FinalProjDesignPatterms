package commands.tasks;

public class UncheckCommand extends  TaskCommand{
    @Override
    public String description() {
        return "Set task as undone, use: uncheck <id>.";
    }
}
