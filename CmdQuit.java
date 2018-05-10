/**
 * Class for shell command {@code clear}
 */
public class CmdQuit implements Command{

    /**
     * Quit the shell
     * @return empty string
     */
    @Override
    public String execute() {
        return "";
    }

    /**
     * Try to match the input command to {@code quit}
     * @param cmd
     * @return {@code true} if command is an abbreviation of clear}
     */
    @Override
    public boolean matches(String cmd) {
        return ( "quit".startsWith(cmd.toLowerCase()) );
    }
}
