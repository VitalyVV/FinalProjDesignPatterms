import java.util.ArrayList;
import java.util.HashMap;

public class TaskAgency {

    //private ArrayList<Project> projects = new ArrayList<>();
    private HashMap<String, Project> projects = new HashMap<>();

    public void addNewProject(String name){
        projects.put(name, new Project(name));
    }

    public void addNewTask(String projectName, String description){
        projects.get(projectName).addTask(TaskFactory.getNewTask(description, false));
    }

    public void addNewSubTask(long id, String description){
        Task t = findTaskById(id);
        if(t != null){
            t.addTask(TaskFactory.getNewTask(description, false));
        }
    }

    public Task findTaskById(long id){
        Task t;
        for(Project p: projects.values()){
             t = p.getTask(id);
             if(t != null) return t;
        }
        return null;
    }
}
