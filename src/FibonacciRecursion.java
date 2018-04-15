import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciRecursion {
    Map<Integer, Integer> cache = new HashMap<>();
    int cnt;

    private int fibbonaci(int n) {
        cnt ++;
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)){
            return cache.get(n);
        }
        int result = fibbonaci(n-2) + fibbonaci(n - 1);
        cache.put(n, result);
        return result;
    }

    private void run(int n) {
        System.out.println(fibbonaci(n));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        new FibonacciRecursion().run(d);
    }
}
