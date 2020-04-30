import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Project {
    private List<Task> commands = new ArrayList<>();
    private Mediator mediator;
    private Calendar deadline;
    private String name;

    public Calendar getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }

    public Project(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Expecting to have dd mm yy.
     * If empty attempts to show deadline would throw NullPointerException to handle.
     *
     * @param date
     * @return
     */
    public Project addDeadline(String date){
        if (date.equals("")){
            return this;
        }
        String[] temp = date.split(" ");
        Calendar datetime = new GregorianCalendar();
        datetime.set(Calendar.YEAR, Integer.parseInt(temp[2]));
        datetime.set(Calendar.MONTH, Integer.parseInt(temp[1]));
        datetime.set(Calendar.DATE, Integer.parseInt(temp[0]));

        deadline = datetime;
        return this;
    }

    public Project addName(String name){
        this.name = name;
        return this;
    }

    public void addTask(Task task){
        commands.add(task);
        mediator.add(task, this);
    }

    public void addTask(long id, String description){
        Task task = new Task(id, description, false);
        this.addTask(task);
    }
}
