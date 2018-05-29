package A_correctBracelets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Character[] c = {'(', '[', '{'};
        HashMap<Character, Character> chars = new HashMap<>();
        chars.put('(', ')');
        chars.put('[', ']');
        chars.put('{', '}');


        Stack<Character> stack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        for (int i = 0; i < input.length(); ++i) {
            Character character = input.charAt(i);
            if (chars.containsKey(character) || chars.containsValue(character)) {
                intStack.push(i);


                if (chars.containsKey(character)) {
                    stack.push(character);
                } else {
                    if (stack.isEmpty() || !chars.get(stack.pop()).equals(character)) {
                        System.out.println(i + 1);

                        return;
                    } else {
                        intStack.pop();
                        intStack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.print("Success");
        } else {
            int firstError = intStack.pop();

            while (!intStack.isEmpty()){
                firstError = intStack.pop();
            }
            System.out.print(firstError + 1);
        }
    }
}
