public interface TaskComponent {

    long getId();

    String getDescription();

    boolean isDone();

    void setDone(boolean done);
}
