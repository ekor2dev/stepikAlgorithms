import javafx.scene.effect.InnerShadow;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException{
        new Main().run();
    }

    public void run() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] capacityAndN = reader.readLine().split(" ");
        int W = Integer.parseInt(capacityAndN[0]) + 1;
        int n = Integer.parseInt(capacityAndN[1]) + 1;
        String[] tokens = reader.readLine().split(" ");
        int[] array = new int[n];
        int[] c = new int[n + 1 ];
        for (int i = 0; i < n -1; ++i){
            array[i ] = Integer.parseInt(tokens[i ]);
            c[ i + 1] = array[i];
        }

      //  System.out.println(Arrays.toString(array));

        int[][] D = new int[W][n];
        for(int w = 0; w < W; ++w){
            D[w][0] = 0;
        }
        for (int i = 0; i < n; ++i){
            D[0][i] = 0;
        }

        for (int i = 1; i < n; ++i){
            for (int w = 1; w < W; ++w){
                D[w][i] = D[w][i-1];
                if(c[i ] <= w){
                    D[w][i] = Integer.max(D[w][i], D[w - c[i ]][i -1] + c[i ]);
                }
            }
        }
        System.out.print(D[W -1][n-1]);
      //  System.out.print(Arrays.deepToString(D));



    }


}
