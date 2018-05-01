/**
 * Launches a simple shell to create, modify and output
 * an AVL Tree data structure
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class Shell {

    /**
     * Provide a command shell to execute operations an a AVLTree
     * @param args
     * @throws IOException
     */
    public static void main ( String [] args) throws IOException {

        AVLTree myAVLTree = new AVLTree<String, Body>();
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> commandTokens;

        boolean quit = false;
        while (!quit) {

            // read command from shell
            System.out.print("avltree> ");
            String input = stdin.readLine();
            if (input == null) { break; }

            // strip obsolete spaces and fill ArrayList with command and params
            input.replaceAll("\\s+?"," ");
            input.trim();
            commandTokens = new ArrayList<String>(Arrays.asList
                                (input.replaceAll("\\s+", " ").split(" ")));

            // create command instances
            ClearCommand clearCommand = new ClearCommand(myAVLTree);
            PutCommand putCommand = new PutCommand (myAVLTree, commandTokens );
            HelpCommand helpCommand = new HelpCommand();
            QuitCommand quitCommand = new QuitCommand();
            InvalidCommand invalidCommand = new InvalidCommand();

            // command execution
            switch (commandTokens.get(0).toLowerCase()){
                case "clear":
                    clearCommand.execute(); break;
                case "put":
                    putCommand.execute(); break;
                case "remove": break;
                case "objects": break;
                case "debug": break;
                case "help":
                    helpCommand.execute(); break;
                case "quit":
                    quitCommand.execute(); break;
                default:
                    invalidCommand.execute();
            }
        }
    }
}