import java.util.ArrayList;

/**
 * Class for shell command {@code remove}
 */
public class CmdRemove implements Command {

    private ArrayList<String> commandTokens;

    private AvlTreeMap avlTreeMap;

    public CmdRemove(AvlTreeMap avlTreeMap, ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap = avlTreeMap;
    }

    /**
     * Remove node from tree.
     * @return empty string if removal is successful, otherwise error messGE
     */
    @Override
    public String execute() {
        return "not yet implemented";
    }

    /**
     * Try to match the input command to {@code remove}
     * @param cmd
     * @return {@code true} if command is an abbreviation of remove}
     */
    @Override
    public boolean matches(String cmd) {
        return ("remove".startsWith(cmd.toLowerCase()));
    }
}
