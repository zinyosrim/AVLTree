import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Launch a simple shell to create, modify and output
 * an AVL Tree data structure
 */
public final class Shell {

    /**
     * Provide a command shell to execute operations an a AvlTreeMap
     * @param args main parameters
     * @throws IOException for handling input
     */
    public static void main ( String [] args) throws IOException {

        // AvlTreeMap initialization
        Comparator<String> myComparator = String::compareTo;
        AvlTreeMap<String, ThreeDObject> avlTreeMap = new AvlTreeMap<>(myComparator);

        // Command shell initialization
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> commandTokens;

        // Command shell operations
        boolean userCommandIsNotQuit = true;

        while (userCommandIsNotQuit) {

            // Read command from shell
            System.out.print("PROMPT> ");
            String input = stdin.readLine();

            // Remove obsolete spaces and fill ArrayList with command and params
            //input.replaceAll("\\s+?"," ");
            input.trim();
            commandTokens = new ArrayList<String>(Arrays.asList
                                (input.replaceAll("\\s+", " ").split(" ")));

            // create command instances
            CmdClear cmdClear       = new CmdClear(avlTreeMap);
            CmdFind cmdFind         = new CmdFind(avlTreeMap, commandTokens);
            CmdPut cmdPut           = new CmdPut(avlTreeMap, commandTokens);
            CmdRemove cmdRemove     = new CmdRemove(avlTreeMap, commandTokens);
            CmdObjects cmdObjects   = new CmdObjects(avlTreeMap);
            CmdDebug cmdDebug       = new CmdDebug(avlTreeMap);
            CmdHelp cmdHelp         = new CmdHelp();
            CmdVolume cmdVolume     = new CmdVolume(avlTreeMap, commandTokens);
            CmdSurface cmdSurface   = new CmdSurface(avlTreeMap, commandTokens);
            CmdQuit cmdQuit         = new CmdQuit();

            List<Command> allowedCommands  = Arrays.asList(
                                                cmdClear, cmdFind, cmdPut,cmdRemove,cmdObjects,
                                                cmdDebug, cmdHelp, cmdVolume, cmdSurface, cmdQuit);
            boolean commandMatched = false;

            for (Command cmd : allowedCommands) {

                if (cmd.matches(commandTokens.get(0))) {
                    System.out.print(cmd.execute());
                    commandMatched = true;
                }
            }

            if (!commandMatched) {
                    System.out.print("Error! Invalid command. Enter HELP for valid commands.\n");
            }

            if (cmdQuit.matches(commandTokens.get(0))) {
                        userCommandIsNotQuit = false;
            }
        }
    }
}

