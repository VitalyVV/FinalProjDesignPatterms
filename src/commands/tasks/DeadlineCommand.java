package commands.tasks;

public class DeadlineCommand extends TaskCommand {

    @Override
    public String description() {
        return "adds deadline to task, use: deadline <ID> <dd.mm.yy>";
    }
}
