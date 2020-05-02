public class Application {

    private ApplicationContext context = ApplicationContext.getInstance();


    public Application() {
        context.addCommand(new HelpCommand());
        context.addCommand(new ErrorCommand());
        context.addCommand(new AddProjectCommand(context.getMediator()));
    }

    public void run(){
        while(true){
            break;
        }
    }

}
