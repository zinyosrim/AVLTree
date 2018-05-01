/**
 * Created by ZY on 01.05.18.
 */
public class HelpCommand implements Command{

    public HelpCommand() {
    }

    @Override
    public void execute() {
        System.out.print("Valid commands are: HELP, NEW, TRIE, QUIT, ADD <key> <points>, CHANGE <key> <points>, DELETE <key>\n");
    }
}
