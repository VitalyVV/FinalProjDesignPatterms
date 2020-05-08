package commands;

public interface Command {
    void execute(String command);
    String description();
}
