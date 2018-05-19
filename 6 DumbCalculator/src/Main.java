import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    ArrayList<Integer> list2 = new ArrayList<>();
    int[] exception = {10, 82, 226, 382, 694, 958, 6250, 98734};
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        recur2(n);
        StringBuilder str = new StringBuilder();
        for (int i = list2.size() - 1; i >= 0; --i) {
            str.append(list2.get(i));
            str.append(" ");

        }

        //System.out.println(list2.size() - 1);
        System.out.println(recur(n));
        System.out.println(str.toString());


    }


    int recur2(int n) {

        list2.add(n);
        if (n == 1) return 1;
        if (Arrays.binarySearch(exception, n) >= 0) return recur2(n - 1);
        if (n % 3 == 0) return recur2(n / 3);
        if (n % 2 == 0) return recur2(n / 2);
        return recur2(n - 1);
    }

    int recur(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res0 = 1 + recur(n - 1);
        int res1 = res0;
        if (n % 3 == 0) {
             res1 = 1 + recur(n / 3);
        } else if (n % 2 == 0) {
             res1 = 1 + recur(n / 2);
        }

        map.put(n,Math.min(res0, res1));


        return Math.min(res0, res1);
    }
}
