/**
 * Launches a simple shell to create, modify and output
 * a AVL Tree data structure
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class Shell {

    private Shell(){}

    /**
     * Provide a command shell to execute operations an a trie
     * @param args
     * @throws IOException
     */
    public static void main ( String [] args) throws IOException {

        AVLTree myAVLTree = new AVLTree<String, Body>();
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));

        boolean quit = false;
        while (!quit) {
            System.out.print("avltree> ");
            String input = stdin.readLine();
            if (input == null) {
                break;
            }

            input.trim().replaceAll(" +", " ");

            ArrayList<String> commandTokens =
                    new ArrayList<String>(Arrays.asList(input.split(" ")));

            /*for (String token : commandTokens){
                System.out.println(token);
            }*/

            switch (commandTokens.get(0).toLowerCase()){
                case "clear":
                    ClearCommand clearCommand =
                            new ClearCommand(myAVLTree);
                    clearCommand.execute();
                    break;
                case "put":
                    PutCommand putCommand =
                            new PutCommand (myAVLTree, commandTokens ) ;
                    putCommand.execute();
                    break;
                case "remove": break;
                case "objects": break;
                case "debug": break;
                case "help": break;
                case "quit": break;
                default:

            }




            //avlCommand command = new Command(input, avltree);
            //command.execute();
        }
    }
}