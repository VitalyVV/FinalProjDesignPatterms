public interface Mediator {
    public void delete(Task task, Project project);
    public void add(Task task, Project project);
    public void addTask(Task task, Project project);
    public void check(Task task);
}
