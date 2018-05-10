import java.util.Iterator;

/**
 * Class for shell command {@code object}
 */
public class CmdObjects implements Command {

    private AvlTreeMap myAvlTreeMap;

    public CmdObjects(AvlTreeMap myAvlTreeMap){
        this.myAvlTreeMap = myAvlTreeMap;
    }

    /**
     * Return an AVLTree in form of a string such as [a, b, c, ...] in in-order
     * @return String representation of an AVL Tree's in-order traversal
     */
    @Override
    public String execute() {
        StringBuilder objectsString = new StringBuilder();
        Iterator iterator = myAvlTreeMap.iterator();
        objectsString.append("[");

        if (!myAvlTreeMap.isEmpty()) {

            while (iterator.hasNext()) {
                objectsString.append(iterator.next());

                if (iterator.hasNext()) {
                    objectsString.append(", ");
                }
            }
        }
        objectsString.append("]\n");
        return objectsString.toString();
    }

    /**
     * Match the shell command {@code object}
     * @param cmd
     * @return {@code true} if input parameter specifies the shell command {@code object}
     */
    @Override
    public boolean matches(String cmd) {
        return ( "objects".startsWith(cmd.toLowerCase()) );
    }
}