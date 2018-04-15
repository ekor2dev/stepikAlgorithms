import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    String first;
    String second;
    int[][] d;
    boolean[][] calculated;


    private int editingDistance(int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0) return m;
        if (m == 0) return n;
        if (calculated[n][m]) {
            return d[n][m];
        }
        int res1 = editingDistance(n, m - 1) + 1;
        int res2 = editingDistance(n, m - 1) + 1;
        int res3 = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
        int result = Math.min(Math.min(res1, res2), res3);
        d[n][m] = result;
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    public void run() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        //   Scanner s = new Scanner(new File("input.txt"));
        first = s.next();
        second = s.next();
        d = new int[first.length() + 1][second.length() + 1];
        calculated = new boolean[first.length() + 1][second.length() + 1];

        System.out.println(editingDistance(first.length(), second.length()));

    }
}
