package commands.tasks;

public class CheckCommand extends TaskCommand {
    @Override
    public String description() {
        return "Set task as done, use: check <id>.";
    }
}
