package A_arrayToHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    int[]  heap;
    ArrayList<String> moves;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        // BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
   heap =(Arrays.stream(input).mapToInt(Integer::parseInt).toArray());
   moves = new ArrayList<>();
      //  System.out.println(   Arrays.toString(heap));
  for (int i = (heap.length - 1)/2; i  >= 0; --i){
      swiftDown(i);
  }

        System.out.println(moves.size());


      moves.forEach(System.out::println);
    }


    int leftIndex(int parent){
        return 2*parent + 1;
    }
    int rightIndex(int parent){
        return  2*parent + 2;
    }

    void swiftDown(int i){
        int minIndex = i;
        int l = leftIndex(i);
        if(l < heap.length && heap[l] < heap[minIndex]){
            minIndex = l;
        }
        int r = rightIndex(i);
        if(r < heap.length && heap[r] < heap[minIndex]){
            minIndex = r;
        }

        if (i != minIndex){
            int tmp = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = tmp;
            moves.add(i + " " + minIndex);
            swiftDown(minIndex);
        }
    }







}


