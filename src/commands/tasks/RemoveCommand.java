package commands.tasks;

public class RemoveCommand extends TaskCommand {
    @Override
    public String description() {
        return "remove task from project or task, use: remove <id>";
    }
}
