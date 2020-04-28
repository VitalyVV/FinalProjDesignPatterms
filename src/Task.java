import java.util.ArrayList;

public class Task {
    private final long id;
    private final String description;
    private boolean done;

    private ArrayList<Task> subTasks = new ArrayList<>();

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
        for(Task task: subTasks)
            task.setDone(done);

    }

    public void addTask(Task task){
        subTasks.add(task);
    }

}
