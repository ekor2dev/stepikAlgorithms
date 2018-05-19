import javafx.scene.effect.InnerShadow;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int[] array = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            array[i + 1] = Integer.parseInt(tokens[i]);
        }
        int[] sum = new int[n + 1];

        //  System.out.print(Arrays.toString(array));
        for (int i = 0; i < n + 1; ++i) {
            if (i < 2) {
                sum[i] = array[i];
            } else {
                sum[i] = array[i] + Math.max(sum[i - 1], sum[i - 2]);
            }


        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(sum));
        System.out.print(sum[n]);
    }
}