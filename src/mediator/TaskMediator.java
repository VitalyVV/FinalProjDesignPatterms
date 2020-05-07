package mediator;

import application.ApplicationContext;
import commands.Command;
import exceptions.NoTaskProjectException;
import exceptions.ParametersException;
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

    @Override
    public void notify(Object sender, String data) throws ParametersException, NoTaskProjectException {
        if (sender instanceof Command) {
            notifyCommand(data);
        }else if(sender instanceof TaskAgency){
            notifyAgency(data);
        }
    }

    private void notifyCommand(String data) throws ParametersException, NoTaskProjectException {
        String[] params = data.split(" ");
        switch (params[0]) {
            case "add":
                if (params.length > 3)
                    add(params[1], params[3], params[2]);
                else
                    if(params.length < 3) throw new ParametersException("Missing parameters for add command.");
                    add(params[1], params[2], null);
                break;
            case "deadline":
                if(params.length < 3) throw new ParametersException("Missing parameters for deadline command.");
                taskAgency.addDeadline(Long.parseLong(params[1]), params[2]);
                break;
            case "remove":
                if(params.length < 2) throw new ParametersException("Missing parameters for remove command.");
                removeTask(Long.parseLong(params[1]));
                break;
            case "check":
                if(params.length < 2) throw new ParametersException("Missing parameters for check command.");
                checkTask(Long.parseLong(params[1]));
                break;
            case "uncheck":
                if(params.length < 2) throw new ParametersException("Missing parameters for uncheck command.");
                uncheckTask(Long.parseLong(params[1]));
                break;
            case "show":
                showTask(params.length>1 && params[1].equals("ids"));
                break;
            case "today":
                showTodayDeadlines(params.length>1 && params[1].equals("ids"));
        }
    }

    private void notifyAgency(String data){
        String[] params = data.split(" ", 2);
        if(params[0].equals("list")){
            ApplicationContext.getInstance().writeln(params[1]);
        }
    }

    private void add(String type, String title, String parent) throws NoTaskProjectException, ParametersException {
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
            default: throw new ParametersException("No such subcommand for add");
        }
    }


    public void showTodayDeadlines(boolean showId) throws ParametersException, NoTaskProjectException {
        taskAgency.listTasks(showId, true);
    }

    public void addProject(String name){
        taskAgency.addNewProject(name);
    }

    public void addTask(String description, String projectName) throws NoTaskProjectException {
        taskAgency.addNewTask(projectName, description);
    }

    public void removeTask(long id) throws NoTaskProjectException {
        taskAgency.removeTask(id);
    }

    public void checkTask(long id) throws NoTaskProjectException {
        taskAgency.setTaskDone(id, true);
    }

    public void showTask(boolean showId) throws ParametersException, NoTaskProjectException {
        taskAgency.listTasks(showId, false);
    }

    public void uncheckTask(long id) throws NoTaskProjectException {
        taskAgency.setTaskDone(id, false);
    }

    public void addSubTask(String description, long id) throws NoTaskProjectException {
        taskAgency.addNewSubTask(id, description);
    }
}
