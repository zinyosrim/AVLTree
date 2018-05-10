import java.util.ArrayList;

/**
 * Class for shell-command for cuboid insertion into the tree  (e.g. put key cuboid 1 2 3 4 5 6)
 */
public class CmdPutCylinder implements Command{

    private final int CYLINDER_NUMBER_OF_PARAMS = 8;

    private final int INDEX_OF_KEY = 1;

    private final int INDEX_OF_X = 3;

    private final int INDEX_OF_Y = 4;

    private final int INDEX_OF_Z = 5;

    private final int CYLINDER_INDEX_OF_R = 6;

    private final int CYLINDER_INDEX_OF_H = 7;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    private ArrayList<String> commandTokens;

    public CmdPutCylinder(AvlTreeMap<String, ThreeDObject> avlTreeMap,
                          ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = avlTreeMap;
    }

    /**
     * Insert a cylinder into the avl-tree if coordinates and dimensions are passed properly
     * @return empty string if insertion successful, else error message
     */
    @Override
    public String execute() {
        if (this.commandTokens.size() == CYLINDER_NUMBER_OF_PARAMS) {
            avlTreeMap.put(this.commandTokens.get(INDEX_OF_KEY),
                           new ThreeDCylinder(
                               Double.parseDouble(this.commandTokens.get(INDEX_OF_X)),
                               Double.parseDouble(this.commandTokens.get(INDEX_OF_Y)),
                               Double.parseDouble(this.commandTokens.get(INDEX_OF_Z)),
                               Double.parseDouble(this.commandTokens.get(CYLINDER_INDEX_OF_R)),
                               Double.parseDouble(this.commandTokens.get(CYLINDER_INDEX_OF_H))));
            return "";

        } else return "Error! PUT for CYLINDER requires 5 parameters.\n";
    }

    @Override
    public boolean matches(String cmd) {
        return ("cylinder".startsWith(cmd.toLowerCase()) );
    }
}
