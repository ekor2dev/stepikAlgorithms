import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        new Main().run2();
    }

    private void run2() throws FileNotFoundException{
        Scanner s = new Scanner(new File("input.txt"));
       // Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int i = 0; i < n; ++i){
        String command = s.next();
        if (command.equals("Insert") ){
        int newElement = s.nextInt();
        heap.add(newElement);}
        else {
            System.out.println(heap.poll());}
        }
     //   System.out.println(Arrays.toString(heap.items));

        }


    }

