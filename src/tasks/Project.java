package tasks;

import mediator.Mediator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Project {

    private String name;
    private ArrayList<Task> taskList = new ArrayList<>();
    private Mediator mediator;

    public Project(Mediator mediator, String name){
        this.name = name;
        this.mediator = mediator;
    }

    public String getName(){
        return name;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public Task getTask(long id){
        for(Task t: taskList) {
            if (t.getId() == id) return t;
            Task tmp = t.getSubTask(id);
            if (tmp != null) return tmp;
        }
        return null;
    }

    public Task[] getTasks(){
        return taskList.toArray(new Task[0]);
    }

    public void removeTask(long id){
        for(Task t: taskList) {
            if (t.getId() == id) taskList.remove(t);
            t.removeSubTask(id);
        }
    }
    
}
