/**
 * Created by ZY on 01.05.18.
 */
public class HelpCommand implements Command{

    public HelpCommand() {}

    @Override
    public void execute() {
        System.out.print("Valid commands in the AVLTree command shell are:\n\n"+
                "CLEAR   : creates a new empty AVLTree\n" +
                "PUT k b : adds a 3D-object node b with key k to the AVLTree\n"+
                "          Options for b are:\n" +
                "REMOVE k: removes the node with the key k from the AVLTree\n"+
                "OBJECTS :\n" +
                "DEBUG   :\n" +
                "QUIT    : Quits the AVLTree shell\n" +
                "HELP    : Displays this message\n\n");
    }
}
