package commands;

import application.Application;
import application.ApplicationContext;
import mediator.Mediator;
import tasks.Project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodayCommand implements Command {
    @Override
    public void execute(String command) {
        ApplicationContext.getInstance().getMediator().notify(this, command);
    }

    @Override
    public String description() {
        return "Shows projects which deadline is today";
    }
}
