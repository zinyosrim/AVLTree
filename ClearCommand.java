/**
 * Created by ZY on 01.05.18.
 */
public class ClearCommand {

    AVLTree avltree;

    public ClearCommand(AVLTree avltree){
        avltree = new AVLTree<String, Body>();
    }

    public void execute(){
        // avltree.put
        System.out.println("Execute clear " );
    }
}
