import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    String first;
    String second;
    int[][] d;





    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    public void run() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        //   Scanner s = new Scanner(new File("input.txt"));
        first = s.next();
        second = s.next();
        d = new int[first.length() + 1][second.length() + 1];



        for (int n = 0; n <= first.length(); ++n){
            for (int m = 0; m <= second.length(); ++m){
                if (n == 0 && m == 0) {
                    d[n][m] =  0;
                }
                else if (n == 0){ d[n][m]  =  m;}
                else if (m == 0){ d[n][m]  = n;}
                else {


                    int res1 = d[n][m - 1] + 1;
                    int res2 = d[n - 1][m] + 1;
                    int res3 = d[n - 1][m - 1] + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
                    int result = Math.min(Math.min(res1, res2), res3);
                    d[n][m] = result;
                }
            }

        }

        System.out.println(d[first.length()][ second.length()]);

    }
}
