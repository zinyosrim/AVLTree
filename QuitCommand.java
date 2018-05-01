/**
 * Created by ZY on 01.05.18.
 */
public class QuitCommand implements Command{

    public QuitCommand(){}

    @Override
    public void execute() { System.exit(0); }
}
