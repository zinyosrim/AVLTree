/**
 * Class for shell command {@code clear}
 */
public class CmdClear implements Command {

    private AvlTreeMap avltree;

    public CmdClear(AvlTreeMap avltree){
        this.avltree = avltree;
    }

    /**
     * Initialize the AVL tree to an empty tree
     * @return empty String
     */
    public String execute(){
        this.avltree.clear();
        return "";
    }

    /**
     * Try to match the input command to {@code clear}
     * @param cmd
     * @return {@code true} if command is an abbreviation of clear}
     */
    @Override
    public boolean matches(String cmd) {
        return ("clear".startsWith(cmd.toLowerCase()));
    }
}
