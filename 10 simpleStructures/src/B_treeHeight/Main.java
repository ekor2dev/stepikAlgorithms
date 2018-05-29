package B_treeHeight;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
   int[] tree;
    ArrayDeque<Integer> treeQue;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
         tree = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        treeQue = new ArrayDeque<>();


        int head = 0;
               for(int i = 0; i < tree.length; ++i) {
            if(tree[i] == -1){
                   head = i;
            }
            else{
                treeQue.add(i);
            }
        }
        System.out.println(getHeight(head));
    }

    private ArrayList<Integer> getChildren(int parent){

        ArrayList<Integer> children = new ArrayList<>();
        System.out.print(parent);
        int finish = treeQue.size();
        for(int i = 0; i < finish  && !treeQue.isEmpty(); ++i){

           System.out.print(treeQue);
            Integer test = treeQue.poll();

            if (tree[test] == parent){
                children.add(test);
            }
            else{
                treeQue.add(test);
            }
        }
//       System.out.print(treeQue);
//        System.out.print(children);
       System.out.println();
        return children;
    }

    private int getHeight(int parent){
        ArrayList<Integer> children = getChildren(parent);
        if ( children.size() == 0) {
//            System.out.print("////");
            return 1;
        }
        else {
            int[] heights = new int[children.size()];
            for(int  i = 0; i < children.size(); ++i){
                heights[i] = getHeight(children.get(i));
            }


            return 1 +  Arrays.stream(heights).max().getAsInt();
        }
    }



}


