import javafx.scene.effect.InnerShadow;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException{
        new Main().run();
    }

    public void run() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
      //  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = Integer.parseInt(tokens[i]);
        }

      //  System.out.println(Arrays.toString(array));


        int[] maxLength = new int[n];
        for (int i = 0; i < n; ++i){
            maxLength[i] = 1;
            for (int j = 0; j < i; ++j ){
               // System.out.println(array[j] +" " + array[i]);
                if(array[j] >= array[i] && maxLength[j] + 1 > maxLength[i]){
                    maxLength[i] = maxLength[j] + 1;

                }
            }
        }

        int maxAmount = 0;
        int lastIndex = 0;
        int maxElement = 0;

        for (int i = 0; i < n; ++i){
            if (maxLength[i] > maxAmount){
                maxAmount = maxLength[i];
                lastIndex = i;
            }
        }

        int[] indecies = new int[maxAmount];
        indecies[maxAmount - 1] = lastIndex;
        int indexToWrite = maxAmount - 2;
        for (int i = lastIndex - 1; i > 0; --i){
            if(maxLength[i] == maxLength[indecies[indexToWrite + 1]] -1 && array[i]  >=  array[indecies[indexToWrite + 1]]){
                indecies[indexToWrite] = i;
                --indexToWrite;
            }
        }





        System.out.println(maxAmount);
        System.out.println(Arrays.toString(maxLength));
        for (int index: indecies){
            System.out.print(index + 1);
            System.out.print(" ");
        }

    }
}
