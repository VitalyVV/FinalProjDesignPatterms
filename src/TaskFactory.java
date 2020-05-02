public class TaskFactory {

    private static long id = 1;

    public static Task getNewTask(String description, boolean isDone){
        return new Task(id, description, isDone);
    }
}
