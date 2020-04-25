import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.PrintWriter;

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

    private static ApplicationContext instance;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

}
