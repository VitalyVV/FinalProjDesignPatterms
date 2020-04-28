import java.util.ArrayList;

public class Project {

    private String name;
    private ArrayList<Task> taskList = new ArrayList<>();

    public Project(String name){
        this.name = name;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public Task getTask(long id){
        for(Task t: taskList)
            if(t.getId() == id) return t;
        return null;
    }

}
