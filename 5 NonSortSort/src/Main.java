import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max  = 10;
        int[] count = new int[max + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; ++i){
            int newEl = Integer.parseInt(input[i]);
            count[newEl] = count[newEl] + 1;
        }
        for (int i = 0; i <= max; ++i){
            for(int j = 0; j < count[i]; ++j){
                System.out.printf("%d ", i);
            }
        }
        //System.out.print(Arrays.toString(count));
    }
}
