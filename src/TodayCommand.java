import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodayCommand implements Command {
    @Override
    public void execute(String command) {
        ArrayList<Project> projects = ApplicationContext.getInstance().getProjects();
        Calendar today = new GregorianCalendar();
        for (Project pj: projects) {
            if (pj.getDeadline().compareTo(today)==0){
                // some printing of this
            }
        }
    }

    @Override
    public String description() {
        return "Shows projects which deadline is today";
    }
}
