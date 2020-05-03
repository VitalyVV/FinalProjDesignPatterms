package application;

import commands.Command;
import mediator.Mediator;
import mediator.TaskMediator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ApplicationContext {

    public static ApplicationContext getInstance() {
        if(instance == null) instance = new ApplicationContext();
        return instance;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public void writeln(String s) {
        out.println(s);
        out.flush();
    }

    public void write(String s) {
        out.print(s);
        out.flush();
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    void addCommand(String commandName, Command command){
        commands.put(commandName, command);
    }
    public HashMap<String, Command> getCommands(){
        return commands;
    }

    public Mediator getMediator(){
        return taskMediator;
    }

    private static ApplicationContext instance;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    private HashMap<String, Command> commands = new HashMap<>();
    private Mediator taskMediator = new TaskMediator();
}
