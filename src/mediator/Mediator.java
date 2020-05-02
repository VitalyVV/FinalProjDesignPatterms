package mediator;

import commands.Command;
import tasks.Project;
import tasks.Task;

public interface Mediator {
    public void delete(Task task, Project project);
    public void add(Task task, Project project);
    public void addTask(Task task, Project project);
    public void check(Task task);

    void notify(Command object, String data);
}
