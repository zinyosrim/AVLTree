/**
 * Launches a simple shell to create, modify and output
 * a AVL Tree data structure
 */


import java.util.ArrayList;
import java.util.Arrays;

public final class TestList {

    public static void main( String args[] ) {
        System.out.println("lorem  ipsum   dolor \n sit.".replaceAll("\\s+", " "));
        String input = "  lorem  ipsum   dolor \n sit.";
        input.trim();
        ArrayList<String> commandTokens =
                //new ArrayList<String>(Arrays.asList(input.split(" ")));
                new ArrayList<String>(Arrays.asList(input.replaceAll("\\s+", " ").split(" ")));

        for (String token: commandTokens){
            System.out.println(token);
        }
    }
}