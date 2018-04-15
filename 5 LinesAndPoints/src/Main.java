import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }


    void run() throws FileNotFoundException, IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");


        int countLines = Integer.parseInt(input[0]);
        int countPoints = Integer.parseInt(input[1]);
        ;
        int[] starts = new int[countLines];
        int[] finishes = new int[countLines];
        for (int i = 0; i < countLines; ++i) {
            input = br.readLine().split(" ");
            starts[i] = Integer.parseInt(input[0]);
            finishes[i] = Integer.parseInt(input[1]);
        }
        Arrays.sort(starts);
        Arrays.sort(finishes);
        input = br.readLine().split(" ");
        for (int i = 0; i < countPoints; ++i) {
            int point = Integer.parseInt(input[i]);
            System.out.println((binaryStartSearch(starts, point) + binaryFinishSearch(finishes, point) - starts.length) + " ");
        }
    }


    int binaryStartSearch(int[] array, int point) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {

            int m = (l + r) / 2;
            if (point == array[m]) {
                ++l;
            } else if (point > array[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r + 1;
    }

    int binaryFinishSearch(int[] array, int point) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (point == array[m]) {
                --r;
            } else if (point >= array[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return array.length - r - 1;
    }
}
