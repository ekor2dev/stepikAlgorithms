package B_ParallelProcesses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        input = reader.readLine().split(" ");

        PriorityQueue<Processor> procQue = new PriorityQueue<>();
        for(int i = 0; i < procCount; ++i){
            procQue.add(new Processor(i));
        }



        for (int i = 0; i < n; ++i) {
            long duration = Long.parseLong(input[i]);
            Processor proc = procQue.poll();

            System.out.println(proc.number+" "+proc.whenWillBeFree);
            proc.addTask(duration);
            procQue.add(proc);




          //  System.out.println(arrival  +"  "+duration);
       //    System.out.println("     "+arrival+","+duration +""+ endTimeQue+ " "+endTimeQue.size());
 //     System.out.println();


        }


    }

    class Processor implements Comparable<Processor>{
        int number;
        long whenWillBeFree;

        public Processor(int number) {
            this.number = number;
            this.whenWillBeFree = 0;
        }

        void addTask(long duration){
            this.whenWillBeFree = this.whenWillBeFree + duration;
        }

        @Override
        public int compareTo(Processor o) {
            int whoWillBeSooner = Long.compare(this.whenWillBeFree, o.whenWillBeFree);
            if (whoWillBeSooner == 0){
                return Integer.compare(this.number, o.number);
            }
        return whoWillBeSooner;
        }
    }




}
