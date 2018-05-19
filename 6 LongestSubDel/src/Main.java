import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  throws IOException{
        new Main().run();
    }

    public void run() throws IOException{

       // BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = Integer.parseInt(tokens[i]);
        }

       // System.out.println(Arrays.toString(array));


        int[] maxLength = new int[n];
        for (int i = 0; i < n; ++i){
            maxLength[i] = 1;
            for (int j = 0; j < i; ++j ){
               // System.out.println(array[j] +" " + array[i]);
                if(array[i] % array[j] ==0   && maxLength[j] + 1 > maxLength[i]){
                    maxLength[i] = maxLength[j] + 1;

                }
            }
        }

        int maxAmount = 0;

        for (int i = 0; i < n; ++i){
            if (maxLength[i] > maxAmount){
                maxAmount = maxLength[i];

            }
        }






        System.out.println(maxAmount);
       // System.out.println(Arrays.toString(maxLength));

    }
}
