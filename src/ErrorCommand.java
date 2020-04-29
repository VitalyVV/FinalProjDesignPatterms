public class ErrorCommand implements Command {

    @Override
    public void execute(String command) {
        System.out.printf("I don't know what the command \"%s\" is.", command);
        System.out.println();
    }

    @Override
    public String description() {
        return null;
    }
}
