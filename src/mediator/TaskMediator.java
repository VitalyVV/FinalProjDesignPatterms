package mediator;

import application.ApplicationContext;
import commands.Command;
import tasks.Project;
import tasks.Task;
import tasks.TaskAgency;

import java.util.*;

/**
 * We assume that we would not need to remove Projects too often.
 * Therefore we made addition and checking for task to be done less
 * time complex than deleting.
 *
 */
public class TaskMediator implements Mediator {
    private TaskAgency taskAgency = new TaskAgency();

    private final static HashMap<Task, List<Project>> taskMap = new HashMap<>();

    @Override
    public void delete(Task task, Project project) {
        List<Project> projects = taskMap.get(task);
        projects.remove(project);
        taskMap.replace(task, projects);
    }

    @Override
    public void add(Task task, Project project) {
        if(taskMap.containsKey(task)){
            taskMap.get(task).add(project);
        }else{
            taskMap.put(
                    task,
                    new ArrayList<Project>(Collections.singletonList(project)));
        }
    }

    @Override
    public void addTask(Task task, Project project){
        taskMap.put(task, new ArrayList<>());
        if (project != null) taskMap.get(task).add(project);
    }

    @Override
    public void check(Task task) {
        task.setDone(true); // Awkward but ok
    }

    @Override
    public void notify(Object sender, String data) {
        String[] params;
        if (sender instanceof Command) {
            params = data.split(" ");
            switch (params[0]) {
                case "add":
                    if (params.length > 3)
                        add(params[1], params[3], params[2]);
                    else add(params[1], params[2], null);
                    break;
                case "show":
                    taskAgency.showTasks();
                    break;
            }
        }else if(sender instanceof TaskAgency){
            params = data.split(" ", 2);
            if(params[0].equals("list")){
                ApplicationContext.getInstance().getOut().println(params[1]);
                ApplicationContext.getInstance().getOut().flush();
            }
        }
    }

    private void add(String type, String title, String parent){
        switch (type) {
            case "project":
                addProject(title);
                break;
            case "task":
                addTask(title, parent);
                break;
            case "subtask":
                addSubTask(title, Long.parseLong(parent));
                break;
        }
    }


    public void addProject(String name){
        taskAgency.addNewProject(this, name);
    }

    public void addTask(String description, String projectName){
        taskAgency.addNewTask(projectName, description);
    }

    public void addSubTask(String description, long id){
        taskAgency.addNewSubTask(id, description);
    }
}
