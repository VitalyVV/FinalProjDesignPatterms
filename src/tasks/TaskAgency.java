package tasks;

import mediator.Mediator;
import tasks.Project;
import tasks.Task;
import tasks.TaskFactory;

import java.util.HashMap;

public class TaskAgency {

    //private ArrayList<tasks.Project> projects = new ArrayList<>();
    private HashMap<String, Project> projects = new HashMap<>();

    public void addNewProject(Mediator mediator, String name){
        projects.put(name, new Project(mediator, name));
    }

    public void addNewTask(String projectName, String description){
        projects.get(projectName).addTask(TaskFactory.createNewTask(description));
    }

    public void removeTask(long id){
        for(Project p: projects.values()){
            p.removeTask(id);
        }
    }

    public void addNewSubTask(long id, String description){
        Task t = findTaskById(id);
        if(t != null){
            t.addTask(TaskFactory.createNewTask(description));
        }
    }

    public Project[] getProjects(){
        return projects.values().toArray(new Project[0]);
    }

    public Project getProject(String name){
        return projects.get(name);
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