import java.util.ArrayList;

/**
 * Class for shell-command for cuboid insertion into the tree  (e.g. put key cuboid 1 2 3 4 5 6)
 */
public class CmdPutSphere implements Command{

    private final int SPHERE_NUMBER_OF_PARAMS = 7;

    private final int INDEX_OF_KEY = 1;

    private final int INDEX_OF_X = 3;

    private final int INDEX_OF_Y = 4;

    private final int INDEX_OF_Z = 5;

    private final int SPHERE_INDEX_OF_R = 6;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    private ArrayList<String> commandTokens;

    public CmdPutSphere(AvlTreeMap<String, ThreeDObject> avlTreeMap,
                        ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = avlTreeMap;
    }

    /**
     * Insert a sphere into the avl-tree if coordinates and dimensions are passed properly
     * @return empty string if insertion successful, else error message
     */
    @Override
    public String execute() {
        if (this.commandTokens.size() == SPHERE_NUMBER_OF_PARAMS) {
            avlTreeMap.put(this.commandTokens.get(INDEX_OF_KEY), new ThreeDSphere(
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_X)),
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_Y)),
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_Z)),
                                   Double.parseDouble(this.commandTokens.get(SPHERE_INDEX_OF_R))));
            return "";

        } else return "Error! PUT for SPHERE requires 4 parameters.\n";
    }

    @Override
    public boolean matches(String cmd) {
        return ("sphere".startsWith(cmd.toLowerCase()) );
    }
}
