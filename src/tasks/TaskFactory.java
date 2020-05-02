package tasks;

import tasks.Task;

public class TaskFactory {

    private static long id = 0;

    public static Task createNewTask(String description){
        id ++;
        return new Task(id, description);
    }
}
