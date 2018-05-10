/**
 * Class for shell command {@code help}
 */
public class CmdHelp implements Command{

    public CmdHelp() {}

    /**
     * Return a help text
     * @return string displaying valid commands
     */
    @Override
    public String execute() {
        return  "Valid commands in the AvlTreeMap command shell are:\n\n"+
                "CLEAR     : Create a new empty AvlTreeMap\n" +
                "PUT k b   : Add a 3D-object b with key k to the AvlTreeMap. Options for b:\n"+
                "                CUBOID x y z l w h\n" +
                "                PYRAMID x y z l w h\n" +
                "                CYLINDER x y z r h\n" +
                "                SPHERE x y z r\n" +
                "VOLUME k  : Output the volume of an object with key k\n" +
                "SURFACE k : Output the area of an object with key k\n" +
                "REMOVE k  : Remove the node with the key k from the AvlTreeMap\n"+
                "OBJECTS   : Output the nodes of the tree in in-order\n" +
                "DEBUG     : Output the keys, nodes and structure of the tree in pre-order\n" +
                "QUIT      : Quit the AvlTreeMap shell\n" +
                "HELP      : Display this message\n";
    }

    /**
     * Try to match the input command to {@code help}
     * @param cmd
     * @return {@code true} if command is an abbreviation of help}
     */
    @Override
    public boolean matches(String cmd) {
        return ( "help".startsWith(cmd.toLowerCase()) );
    }

}
