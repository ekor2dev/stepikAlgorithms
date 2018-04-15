import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printResult(findArray(number));
    }

    private static ArrayList<Integer> findArray(int number){
        int sum = 0;
        int i = 1;
        ArrayList<Integer> array = new ArrayList<>();
        while(sum < number){
            if(number - sum -i >= i + 1 || number - sum - i ==0){
                array.add(i);
                sum +=i;
            }
            ++i;
        }
        return array;
    }

    private static void printResult(ArrayList<Integer> array){
        System.out.println(array.size());
        for (Integer e: array){
            System.out.printf("%d ", e);
        }
    }
}


