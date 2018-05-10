import java.util.ArrayList;

/**
 * Class for shell command {@code volume}
 */
public class CmdVolume implements Command {

    private ArrayList<String> commandTokens;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    public CmdVolume(AvlTreeMap<String, ThreeDObject> avlTreeMap,
                     ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = avlTreeMap;
    }

    /**
     * Return the volume of a ThreeDObject
     * @return double with one decimal place as String
     */
    @Override
    public String execute() {
        String key = this.commandTokens.get(1);
        ThreeDObject value = avlTreeMap.get(key);

        if (value == null) {
            return "Error! " + key + " doesn't exist.\n";

        } else {
            return String.format("%.2f", value.volume()) + "\n";
        }
    }

    /**
     * Match the shell command {@code surface}
     * @param cmd Command
     * @return {@code true} if input parameter specifies the shell command {@code surface}
     */
    @Override
    public boolean matches(String cmd) {
        return ("volume".startsWith(cmd.toLowerCase()));
    }
}