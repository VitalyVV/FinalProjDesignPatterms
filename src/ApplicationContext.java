import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

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

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }


    public TaskAgency getTaskAgency(){
        return taskAgency;

    public void addCommand(Command command){
        commands.add(command);
    }

    public void addProject(Project project){
        projects.add(project);
    }

    public ArrayList<Command> getCommands(){
        return new ArrayList<Command>(commands);
    }

    public ArrayList<Project> getProjects() {
        return new ArrayList<Project>(projects);
    }

    public Project getProjectByName(String name){
        for (Project pj : projects) {
            if(pj.getName().equals(name)){
                return pj;
            }
        }
        return null;
    }

    public Mediator getMediator(){
        return taskMediator;
    }

    private static ApplicationContext instance;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);
    private TaskAgency taskAgency = new TaskAgency();

    private HashSet<Project> projects = new HashSet<>();
    private HashSet<Command> commands = new HashSet<>();
    private Mediator taskMediator = new TaskMediator();
}
