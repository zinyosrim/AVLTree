import java.util.ArrayList;

/**
 * Class for shell command {@code find}
 */
public class CmdFind implements Command {

    private ArrayList<String> commandTokens;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    public CmdFind(AvlTreeMap<String, ThreeDObject> myAvlTreeMap,
                      ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = myAvlTreeMap;
    }

    /**
     * Return the object with a given key
     * @return String representation of object
     */
    @Override
    public String execute() {
        String key = this.commandTokens.get(1);
        ThreeDObject value = avlTreeMap.get(key);

        if (value == null) {
            return "Error! " + key + " doesn't exist.\n";
        } else return value.toString() + "\n";
    }

    /**
     * Match the shell command {@code find}
     * @param cmd
     * @return {@code true} if input parameter specifies the shell command {@code find}
     */
    @Override
    public boolean matches(String cmd) {
        return ("find".startsWith(cmd.toLowerCase()));
    }
}