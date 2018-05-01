/**
 * Launches a simple shell to create, modify and output
 * a AVL Tree data structure
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class TestList {

    private TestList() {
    }

    /**
     * Provide a command shell to execute operations an a trie
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> l = new ArrayList<>();
        l.add("22");
        l.add("33");
        l.add("44");

        for (String token : l) {
            System.out.println(token);
        }

        l.remove(0);
        l.remove(0);
        for (String token : l) {
            System.out.println(token);
        }


    }
}