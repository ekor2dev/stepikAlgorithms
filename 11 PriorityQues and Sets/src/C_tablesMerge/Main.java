package C_tablesMerge;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int procCount = Integer.parseInt(input[0]);
        long n = Integer.parseInt(input[1]);


    }


}


}
