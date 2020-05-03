package tasks;

import application.ApplicationContext;
import mediator.Mediator;
import tasks.Project;
import tasks.Task;
import tasks.TaskFactory;

import java.util.HashMap;
import java.util.Map;

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

    public void showTasks(){
        StringBuilder builder = new StringBuilder("list ");
        for (Map.Entry<String, Project> p : projects.entrySet()) {
            builder.append(p.getKey()).append("\n");
            for(Task t :p.getValue().getTasks()){
                builder.append("  [").append(t.isDone() ? "x" : "").append("]").append(t.getDescription()).append("\n");
//                for(Task st : t.getSubTasks()) {
//                    builder.append("    [").append(st.isDone() ? "x" : "").append("]").
//                            append(st.getDescription()).append("\n");
//                }
            }
        }
        ApplicationContext.getInstance().getMediator().notify(this, builder.toString());
    }
}
