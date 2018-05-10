import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for shell command put
 */
public class CmdPut implements Command {

    private final int INDEX_OF_FIRST_PARAM_OF_TYPE_DOUBLE = 3;

    private ArrayList<String> commandTokens;

    private AvlTreeMap<String, ThreeDObject> avlTreeMap;

    public CmdPut(AvlTreeMap<String, ThreeDObject> avlTreeMap, ArrayList<String> commandTokens){
        this.commandTokens = commandTokens;
        this.avlTreeMap    = avlTreeMap;
    }

    /**
     * Execute shell command put
     * @return empty string if command successful, otherwise error message.
     */
    public String execute(){

        // identify type of 3D object and create specific command instances
        String bodyType = this.commandTokens.get(2).toLowerCase();
        CmdPutCuboid cmdPutCuboid     = new CmdPutCuboid(avlTreeMap, commandTokens);
        CmdPutPyramid cmdPutPyramid   = new CmdPutPyramid(avlTreeMap, commandTokens);
        CmdPutCylinder cmdPutCylinder = new CmdPutCylinder(avlTreeMap, commandTokens);
        CmdPutSphere cmdPutSphere     = new CmdPutSphere(avlTreeMap, commandTokens);

        List<Command> allowedCommands  =
                Arrays.asList(cmdPutCuboid, cmdPutCylinder, cmdPutPyramid, cmdPutSphere);
        boolean commandMatched = false;

        // iterate through valid commands end execute if valid
        for (Command cmd : allowedCommands) {

            if ((cmd.matches(bodyType)) &&  this.paramsAreAllDouble()) {
                System.out.print(cmd.execute());
                commandMatched = true;
            }
        }

        // not a valid command -> output error message
        if (!commandMatched) {
            System.out.print("Error! Invalid PUT command. Enter HELP for valid commands.\n");
        }
        return "";
    }

    /**
     * Check if object coordinates and attributes are all in double format
     * @return true if so.
     */
    private boolean paramsAreAllDouble(){

        // RegEx pattern
        String pattern = "(\\d+\\.?\\d*)";
        Pattern r = Pattern.compile(pattern);

        // iterate through all params and check if they're all of type double
        for (int i = INDEX_OF_FIRST_PARAM_OF_TYPE_DOUBLE; i< commandTokens.size()-1; i++) {
            Matcher m = r.matcher(commandTokens.get(i));

            // there is at least one param which is not double
            if (!m.find()) return false;
        }

        // all are double
        return true;
    }

    /**
     * Match entered command with put
     * @param cmd command
     * @return
     */
    @Override
    public boolean matches(String cmd) {
        return ( "put".startsWith(cmd.toLowerCase()) );
    }
}
