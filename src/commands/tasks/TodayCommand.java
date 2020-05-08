package commands.tasks;

import application.Application;
import application.ApplicationContext;
import commands.Command;
import mediator.Mediator;
import tasks.Project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodayCommand extends TaskCommand {
    @Override
    public String description() {
        return "Shows projects which deadline is today";
    }
}
