package B_rightTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        // BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[]  tree = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int[] heights = new int[n];
        for (int i = 0; i < n; ++i){
            int test = i;
            int height = 1;
            while(tree[test]!=-1){ //heights[test] == 0 &&
                ++height;
                test = tree[test];
            }
            heights[i] = height;
        }
        System.out.println(   Arrays.stream(heights).max().getAsInt());
    }

}


