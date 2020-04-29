import java.util.*;

/**
 * We assume that we would not need to remove Projects too often.
 * Therefore we made addition and checking for task to be done less
 * time complex than deleting.
 *
 */
public class TaskMediator implements Mediator {
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
    public void check(Task task) {
        task.setDone(true); // Awkward but ok
    }
}
