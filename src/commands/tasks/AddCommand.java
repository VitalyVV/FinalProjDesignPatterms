package commands.tasks;

public class AddCommand extends TaskCommand{
    @Override
    public String description() {
        return "Add project/task/subtask, use -e to add existing task, use: " +
                "\nadd <project> <name>" +
                "\nadd <task/subtask> <projectName/parentID> <taskDescription>." +
                "\nadd <task/subtask> -e <projectName/parentID> <taskId>.";
    }
}
