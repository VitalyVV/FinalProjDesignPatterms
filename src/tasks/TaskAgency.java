package tasks;

import application.ApplicationContext;
import exceptions.NoTaskProjectException;
import exceptions.ParametersException;

import java.util.HashMap;
import java.util.Map;

public class TaskAgency {

    private HashMap<String, Project> projects = new HashMap<>();

    public void addNewProject(String name){
        projects.put(name, new Project(name));
    }

    public void addNewTask(String projectName, String description) throws NoTaskProjectException{
        if(!projects.containsKey(projectName)) throw new NoTaskProjectException("No such project " + projectName);
        projects.get(projectName).addTask(TaskFactory.createNewTask(description));
    }

    public void addTask(String projectName, long id) throws NoTaskProjectException{
        if(!projects.containsKey(projectName)) throw new NoTaskProjectException("No such project " + projectName);
        Task t = findTaskById(id);
        if(t == null) throw new NoTaskProjectException("Task is not found.");
        projects.get(projectName).addTask(t);

    }

    public void removeTask(long id) throws NoTaskProjectException{
        for(Project p: projects.values()){
            p.removeTask(id);
        }
    }

    public void addNewSubTask(long id, String description) throws NoTaskProjectException{
        Task t = findTaskById(id);
        if(t != null){
            t.addTask(TaskFactory.createNewTask(description));
        }else throw new NoTaskProjectException("Task is not found.");
    }


    public void addSubTask(long parentId, long taskId) throws NoTaskProjectException{
        Task t = findTaskById(parentId);
        Task t2 = findTaskById(taskId);
        if(t != null && t2 != null){
            t.addTask(t2);
        }else throw new NoTaskProjectException("Task is not found.");
    }

    public Project[] getProjects(){
        return projects.values().toArray(new Project[0]);
    }

    public Project getProject(String name){
        return projects.get(name);
    }

    public void setTaskDone(long id, boolean isDone) throws NoTaskProjectException{
        Task t = findTaskById(id);
        if(t != null){
            t.setDone(isDone);
        }
    }

    public void addDeadline(long id, String deadline) throws NoTaskProjectException {
        Task t = findTaskById(id);
        if(t != null){
            t.setDeadline(deadline);
        }
    }

    public Task findTaskById(long id) throws NoTaskProjectException {
        Task t;
        for(Project p: projects.values()){
             t = p.getTask(id);
             if(t != null) return t;
        }
        throw new NoTaskProjectException("No such task id = " + id);
    }

    public void listTasks(boolean showId, boolean today) throws ParametersException, NoTaskProjectException {
        StringBuilder builder = new StringBuilder("list ");
        for (Map.Entry<String, Project> p : projects.entrySet()) {
            builder.append(p.getKey()).append("\n");
            for(Task t :p.getValue().getTasks()){
                builder.append(t.listTasks(1, showId, today));
            }
        }
        ApplicationContext.getInstance().getMediator().notify(this, builder.toString());
    }

}
