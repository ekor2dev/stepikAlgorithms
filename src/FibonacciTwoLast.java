import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FibonacciTwoLast {
    Map<Integer, Integer> cache = new HashMap<>();

    private int fibbonaci(long n, int mod) {
        if (n < 2) {
            return (int) n;
        }
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < n; ++i ){
           c  = (a + b)%mod;
            a = b;
            b = c;
        }
        return c;
    }

    private void run(long n, int mod) {
        System.out.println(fibbonaci(n, mod));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int mod = scanner.nextInt();
        new FibonacciTwoLast().run(n, mod);
    }
}
