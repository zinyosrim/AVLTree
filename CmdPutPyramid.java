import java.util.ArrayList;

/**
 * Class for shell-command for pyramid insertion into the tree  (e.g. put key pyramid 1 2 3 4 5 6)
 */
public class CmdPutPyramid implements Command{

    private final int PYRAMID_NUMBER_OF_PARAMS = 9;

    private final int INDEX_OF_KEY = 1;

    private final int INDEX_OF_X = 3;

    private final int INDEX_OF_Y = 4;

    private final int INDEX_OF_Z = 5;

    private final int PYRAMID_INDEX_OF_L = 6;

    private final int PYRAMID_INDEX_OF_W = 7;

    private final int PYRAMID_INDEX_OF_H = 8;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    private ArrayList<String> commandTokens;

    public CmdPutPyramid(AvlTreeMap<String, ThreeDObject> avlTreeMap,
                         ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = avlTreeMap;
    }

    /**
     * Insert a PYRAMID into the avl-tree if coordinates and dimensions are passed properly
     * @return empty string if insertion successful, else error message
     */
    @Override
    public String execute() {
        if (this.commandTokens.size() == PYRAMID_NUMBER_OF_PARAMS) {
            avlTreeMap.put(this.commandTokens.get(INDEX_OF_KEY), new ThreeDPyramid(
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_X)),
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_Y)),
                                   Double.parseDouble(this.commandTokens.get(INDEX_OF_Z)),
                                   Double.parseDouble(this.commandTokens.get(PYRAMID_INDEX_OF_L)),
                                   Double.parseDouble(this.commandTokens.get(PYRAMID_INDEX_OF_W)),
                                   Double.parseDouble(this.commandTokens.get(PYRAMID_INDEX_OF_H))));
            return "";

        } else return "Error! PUT for PYRAMID requires 6 parameters.\n";
    }

    @Override
    public boolean matches(String cmd) {
        return ("pyramid".startsWith(cmd.toLowerCase()) );
    }
}
