
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PutCommand implements Command {

    private final int CUBOID_NUMBER_OF_PARAMS = 9;
    private final int CYLINDER_NUMBER_OF_PARAMS = 8;
    private final int PYRAMID_NUMBER_OF_PARAMS = 9;
    private final int SPHERE_NUMBER_OF_PARAMS = 7;
    private final int POSITION_OF_X = 3;

    private ArrayList<String> commandTokens= new ArrayList<String>();
    private AVLTree myAVLTree;
    //private Body body;
    // private Double x, y, z, l, w, h, r;

    public PutCommand(AVLTree myAVLTree, ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.myAVLTree = myAVLTree;
    }

    public void execute(){

        String command = this.commandTokens.get(0);
        String key = this.commandTokens.get(1);
        String bodyType = this.commandTokens.get(2).toLowerCase();

        switch (bodyType) {
            case "cuboid": case "cu":
                if ( this.commandTokens.size() == CUBOID_NUMBER_OF_PARAMS && this.paramsAreAllDouble() ) {
                    System.out.println("invoke "+ command + " " +  key + " " + this.commandTokens.get(3) + " " + this.commandTokens.get(4) + " " + this.commandTokens.get(5) + " " + this.commandTokens.get(6) + " " + this.commandTokens.get(7) + " " + this.commandTokens.get(8));
                } break;
            case "cylinder": case "cy":
                if ( this.commandTokens.size() == CYLINDER_NUMBER_OF_PARAMS && this.paramsAreAllDouble() ) {
                    System.out.println("invoke "+ command + " " +  key + " " + this.commandTokens.get(3) + " " + this.commandTokens.get(4) + " " + this.commandTokens.get(5) + " " + this.commandTokens.get(6) + " " + this.commandTokens.get(7));
                } break;
            case "pyramid": case "p":
                if ( this.commandTokens.size() == PYRAMID_NUMBER_OF_PARAMS && this.paramsAreAllDouble() ) {
                    System.out.println("invoke "+ command + " " +  key + " " + this.commandTokens.get(3) + " " + this.commandTokens.get(4) + " " + this.commandTokens.get(5) + " " + this.commandTokens.get(6) + " " + this.commandTokens.get(7) + " " + this.commandTokens.get(8));
                } break;
            case "sphere": case "s":
                if ( this.commandTokens.size() == SPHERE_NUMBER_OF_PARAMS && this.paramsAreAllDouble() ) {
                    System.out.println("invoke "+ command + " " +  key + " " + this.commandTokens.get(3) + " " + this.commandTokens.get(4) + " " + this.commandTokens.get(5) + " " + this.commandTokens.get(6) );
                } break;
            default:
                System.out.println("Error! Wrong PUT call. Enter HELP for correct Syntax.");
        }
    }

    /**
     * Check if object coordinates and attributes are all double
     * @return true if so.
     */
    private boolean paramsAreAllDouble(){

        // RegEx pattern
        String pattern = "(\\d+\\.?\\d*)";
        Pattern r = Pattern.compile(pattern);

        // iterate through all params and check if they're all of type double
        for (int i = POSITION_OF_X; i< commandTokens.size()-1; i++) {
            Matcher m = r.matcher(commandTokens.get(i));
            // there is at least one param which is not double
            if (!m.find()) return false;
        }
        // all are double
        return true;
    }
}
