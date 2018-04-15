import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FibonacciMod {
    ArrayList<Integer> cache = new ArrayList<>();


    private int fibonaci(int n, int mod) {
        cache.add(1);
        cache.add(1);


        for (int i = 2; i < n ; ++i ){
            cache.add((cache.get(cache.size() - 1 )+ cache.get(cache.size() - 2))%mod);

            if (cache.get(cache.size() - 1 ) == cache.get(1) && cache.get(cache.size() - 2) == cache.get(0)){
                int P = cache.size() -2;
                return cache.get(n % P);
            }

        }
        return cache.get(cache.size() - 1);
    }

    private void run(int n, int mod) {
        System.out.println(fibonaci(n, mod));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mod = scanner.nextInt();
        new FibonacciMod().run(n, mod);
    }
}
