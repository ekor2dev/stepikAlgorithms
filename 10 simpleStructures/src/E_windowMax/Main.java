//package E_windowMax;
//
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayDeque;
//import java.util.Stack;
//import java.util.concurrent.BlockingDeque;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        new Main().run();
//    }
//
//
//    private void run() throws Exception {
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(reader.readLine());
//        String[] input = reader.readLine().split(" ");
//        int windowSize = Integer.parseInt(reader.readLine());
//
//        ArrayDeque<Integer> que = new ArrayDeque<>(Integer.parseInt(input[0]));
//
//        for (int i = 0; i < windowSize; ++i) {
//            window.push(Integer.parseInt(input[i]));
//        }
//        System.out.println(window.max());
//        for (int i = windowSize; i < input.length; ++i) {
//            System.out.println(window.max());
//            System.out.println(window.items);
//            window.pollFirst();
//            window.push(Integer.parseInt(input[i]));
//        }
//        System.out.println(window.max());
//    }
//
//
//
//
//    class Window{
//        BlockingDeque<Integer> que;
//        int maxFirst;
//        int maxSecond;
//
//        public int getMax(){
//            return maxFirst;
//        }
//
//        public void add(int item){
//            que.add(item);
//            int out = que.poll();
//
//            if(out == maxFirst){
//
//            }
//        }
//    }
//}
//
//
