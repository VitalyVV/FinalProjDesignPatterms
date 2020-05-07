package commands.tasks;

public class ShowCommand extends TaskCommand  {
    @Override
    public String description() {
        return "lists all tasks, list with id - add ids, use: show [ids]";
    }
}
