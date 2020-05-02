import java.util.ArrayList;


public class Project {

    private String name;
    private ArrayList<Task> taskList = new ArrayList<>();

    public Project(String name){
        this.name = name;
        mediator = null; 
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public Task getTask(long id){
        for(Task t: taskList)
            if(t.getId() == id) return t;
        return null;
    }
    public Task[] getTasks(){
        return taskList.toArray(new Task[0]);
    }
    
    public Calendar getDeadline() {
        return deadline;
    }
    
    private Mediator mediator;
    private Calendar deadline;


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
    
}
