package tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task {
    private final long id;
    private final String description;
    private boolean done = false;
    private Calendar deadline = null;

    private ArrayList<Task> subTasks = new ArrayList<>();

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    Task(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public void addTask(Task task){
        subTasks.add(task);
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDeadline(){
        return (Calendar) deadline.clone();
    }

    public boolean isDone() {
        return done;
    }

    public Task[] getSubTasks(){
        return subTasks.toArray(new Task[0]);
    }

    public Task getSubTask(long id){
        for (Task t: subTasks) {
            if(t.getId() == id) return t;
        }
        return null;
    }

    public void setDeadline(String date){
        String[] temp = date.split(" ");
        Calendar datetime = new GregorianCalendar();
        datetime.set(Calendar.YEAR, Integer.parseInt(temp[2]));
        datetime.set(Calendar.MONTH, Integer.parseInt(temp[1]));
        datetime.set(Calendar.DATE, Integer.parseInt(temp[0]));
        this.deadline = datetime;
    }

    public void setDone(boolean done) {
        this.done = done;
        for(Task task: subTasks)
            task.setDone(done);

    }

    public void removeSubTask(long id){
        for(Task t: subTasks){
            if(t.id == id) subTasks.remove(t);
        }
    }

}