package mediator;

import application.ApplicationContext;
import commands.Command;
import tasks.Project;
import tasks.Task;
import tasks.TaskAgency;

import java.util.HashMap;
import java.util.List;

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
    public void notify(Object sender, String data) {
        if (sender instanceof Command) {
            notifyCommand(data);
        }else if(sender instanceof TaskAgency){
            notifyAgency(data);
        }
    }

    private void notifyCommand(String data){
        String[] params = data.split(" ");
        switch (params[0]) {
            case "add":
                if (params.length > 3)
                    add(params[1], params[3], params[2]);
                else
                    add(params[1], params[2], null);
                break;
            case "deadline":
                taskAgency.addDeadline(Long.parseLong(params[1]), params[2]);
                break;
            case "rm":
                removeTask(Long.parseLong(params[1]));
                break;
            case "check":
                checkTask(Long.parseLong(params[1]));
                break;
            case "uncheck":
                uncheckTask(Long.parseLong(params[1]));
                break;
            case "show":
                showTask(params.length>3 && params[2].equals("ids"));
                break;
        }
    }

    private void notifyAgency(String data){
        String[] params = data.split(" ", 2);
        if(params[0].equals("list")){
            ApplicationContext.getInstance().writeln(params[1]);
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
        taskAgency.addNewProject(name);
    }

    public void addTask(String description, String projectName){
        taskAgency.addNewTask(projectName, description);
    }

    public void removeTask(long id){
        taskAgency.removeTask(id);
    }

    public void checkTask(long id){
        taskAgency.setTaskDone(id, true);
    }

    public void showTask(boolean showId){
        taskAgency.listTasks(showId);
    }

    public void uncheckTask(long id){
        taskAgency.setTaskDone(id, false);
    }

    public void addSubTask(String description, long id){
        taskAgency.addNewSubTask(id, description);
    }
}
