import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        new Main().run();
    }

    class Node implements Comparable<Node>{
        final int sum;
        String code;
        char symbol;

        void buildCode(String code){
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;

        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node{
        Node left;
        Node right;


        public InternalNode(Node left, Node right){
            super(left.sum + right.sum);
            this.right = right;
            this.left = left;
        }

        @Override
        void buildCode(String code){
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode  extends Node{


        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
        @Override
        void buildCode(String code){
            super.buildCode(code);
            System.out.println(symbol + ": " + code);

        }


    }

    private void run() throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
     //   Scanner s = new Scanner(new File("input.txt"));
        String message = s.next();
        if (message.length() == 1){
            System.out.printf("1 1%n%s: 0%n0", message);
            return;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < message.length(); ++i){
            char c = message.charAt(i);
            if (count.containsKey(c)){
                count.put(c, count.get(c) + 1);
            }
            else{
                count.put(c, 1);
            }
        }

        if (count.size() == 1){
            char letter = message.charAt(0);
            int amount = count.get(letter);

            System.out.printf("1 %d%n%s: 0%n",amount, letter);
         String res = "";
         for (int i = 0; i < amount; ++i){
             res += "0";
         }
            System.out.print(res);
            return;
        }

        Map<Character, Node> codes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e: count.entrySet()){
             LeafNode node = (new LeafNode(e.getKey(), e.getValue()));
            codes.put(node.symbol, node);
            priorityQueue.add(node);
        }


        int sum = 0;
        while (priorityQueue.size() > 1){
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
          //  System.out.printf(left.)
            InternalNode newNode = new InternalNode(left, right);
            sum += newNode.sum;

            priorityQueue.add(newNode);

        }

        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        root.buildCode("");
        String result = "";

        for (int i = 0; i < message.length(); ++i){
            result += (codes.get(message.charAt(i)).code);
        }
        System.out.print(result);






      /*  Map<Character, String> codes = new HashMap<>();
        for (Character e: count.keySet()){
            codes.put(e, count.size() )

                           }*/



    }
}
