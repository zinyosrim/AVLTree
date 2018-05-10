/** The Command interface */
public interface Command {
    String execute();

    boolean matches(String cmd);
}