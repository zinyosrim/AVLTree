/**
 * Created by ZY on 01.05.18.
 */
public class InvalidCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Error! Invalid command. Enter HELP for options");
    }
}
