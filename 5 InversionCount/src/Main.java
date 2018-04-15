import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Main {
    int count = 0;

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }


    void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
       // Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            array[i] = s.nextInt();
        }
       // System.out.println(Arrays.toString(array));

//        int wcount = 0;
//        for (int i = 0; i < length; ++i){
//            for (int j = i + 1; j < length; ++j){
//                if (array[i] >array[j]){
//                    ++wcount;
//                }
//            }
//        }
      // System.out.println(Arrays.toString(merge(new int[] {11}, new int[] {5})));
        //System.out.println(Arrays.toString(mergeSort(new int[] {11, 5, 3,1}, 0, 3)));
        mergeSort(array, 0, length - 1);
        System.out.println( count);

    }

    int[] mergeSort(int[] array, int l, int r){
        if (l < r) {
            int m = (l + r) / 2;
            return merge(mergeSort(array, l, m), mergeSort(array, m + 1, r));
        }
        return new int[] {array[l]};
    }

    int[] merge(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        for (; i < a.length && j < b.length;){
            if (a[i] <= b[j]){
                res[i + j] = a[i];
                ++i;
            }
            else{
                res[i + j] = b[j];
                ++j;
               count += a.length  - i;
            }
        }
        //return res;
        while (i < a.length ){
            res[i + j] = a[i];
            ++i;
        }
        while (j < b.length ){
            res[i + j] = b[j];
            ++j;
        }
return res;
    }


}
