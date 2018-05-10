import java.util.ArrayList;

/**
 * Class for shell command {@code surface}
 */
public class CmdSurface implements Command {

    private ArrayList<String> commandTokens;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    public CmdSurface(AvlTreeMap<String, ThreeDObject> myAvlTreeMap,
                      ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = myAvlTreeMap;
    }

    /**
     * Return the volume of a ThreeDObject
     * @return double with one decimal place as String
     */
    @Override
    public String execute() {
        String key = this.commandTokens.get(1);
        double surf = avlTreeMap.get(key).area();

        if (surf >= 0.){
            return String.format("%.2f", surf) + "\n";
        } return "\n";
    }

    /**
     * Match the shell command {@code surface}
     * @param cmd
     * @return {@code true} if input parameter specifies the shell command {@code surface}
     */
    @Override
    public boolean matches(String cmd) {
        return ("surface".startsWith(cmd.toLowerCase()));
    }

}