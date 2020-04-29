public class Application {

    private ApplicationContext context = ApplicationContext.getInstance();
    private Mediator taskMediator = new TaskMediator();

    public Application() {
        context.addCommand(new HelpCommand());
        context.addCommand(new ErrorCommand());
        context.addCommand(new AddProjectCommand(taskMediator));
    }

    public void run(){
        while(true){
            break;
        }
    }
}
