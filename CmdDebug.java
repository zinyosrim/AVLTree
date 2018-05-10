/**
 * Class for shell command {@code debug}
 */
public class CmdDebug implements Command {

    private AvlTreeMap avltree;

    CmdDebug(AvlTreeMap avltree){
        this.avltree = avltree;
    }

    /**
     * Execute the shell command {@code debug}
     * @return the string representation of the AVL Tree
     */
    @Override
    public String execute() {

        return avltree.toString();
    }

    /**
     * Try to match the input command to {@code debug}
     * @param cmd
     * @return {@code true} if command is an abbreviation of debug}
     */
    @Override
    public boolean matches(String cmd) {
        return ( "debug".startsWith(cmd.toLowerCase()) );
    }
}