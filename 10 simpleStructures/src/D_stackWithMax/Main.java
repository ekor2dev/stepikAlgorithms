package D_stackWithMax;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
       // BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);

        StackWithMax stack = new StackWithMax();
        for(int i = 0; i < n; ++i){
            input = reader.readLine().split(" ");
            String message = input[0];
            if(message.equals("push")){
                stack.push(Integer.parseInt(input[1]));
            }
            else if(message.equals("pop")){
                stack.pop();
            }
            else if (message.equals("max")){
               System.out.println( stack.max());
            }
            else{

            }

        }


        }



        class StackWithMax{
        Stack<Integer> items;
        Stack<Integer> max;

            public StackWithMax() {
                items = new Stack<>();
                max = new Stack<>();
            }

            public int pop(){
            max.pop();
            return items.pop();
        }

        public int max(){
            return max.peek();
        }

        public  void push(int item){
            items.push(item);
            if(max.isEmpty()){
                max.push(item);
            }
            else{
            max.push(Integer.max(max.peek(), item));}
        }
        }
}
