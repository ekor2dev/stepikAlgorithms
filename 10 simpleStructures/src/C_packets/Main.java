package C_packets;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
   //     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int maxSize = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        LinkedBlockingDeque<Integer> endTimeQue = new LinkedBlockingDeque<>();
Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            input = reader.readLine().split(" ");
            int arrival = Integer.parseInt(input[0]);
            int duration = Integer.parseInt(input[1]);
            int endTime = arrival + duration;


            while (!endTimeQue.isEmpty()){
                int maybeFinished = endTimeQue.pollLast();
                //System.out.println(maybeFinished + "1afasfafs!");
                if(maybeFinished > arrival){
//                    stack.push(maybeFinished);
                    endTimeQue.addLast(maybeFinished);
                    break;
                }
            }
//            while(!stack.isEmpty()){
//                endTimeQue.push(stack.pop());
//            }



            if (endTimeQue.isEmpty()) {
                endTimeQue.push(endTime);
                System.out.print(arrival);

            }
        else    if (endTimeQue.size() == maxSize) {
                System.out.print(-1);
            } else {
                System.out.print(endTimeQue.peekFirst());
                endTimeQue.push(endTimeQue.peekFirst() + duration);

            }
          //  System.out.println(arrival  +"  "+duration);
       //    System.out.println("     "+arrival+","+duration +""+ endTimeQue+ " "+endTimeQue.size());
      System.out.println();


        }


    }




}
