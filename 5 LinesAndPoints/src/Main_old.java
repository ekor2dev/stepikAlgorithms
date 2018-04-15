import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_old {
    public static void main(String[] args) throws FileNotFoundException {
        new Main_old().run();
    }


    void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        // Scanner s = new Scanner(System.in);
        int countLines = s.nextInt();
        int countPoints = s.nextInt();
        Line[] linesAscending = new Line[countLines];
        Line[] linesDescending = new Line[countLines];
        for (int i = 0; i < countLines; ++i) {
            Line el = new Line(s.nextInt(), s.nextInt());
            linesAscending[i] = el;
            linesDescending[i] = el;
        }
        Arrays.sort(linesAscending, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Arrays.sort(linesDescending, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Integer.compare(o1.finish, o2.finish);
            }
        });
        
        for (int i = 0; i < countPoints; ++i){
            int point = s.nextInt();
            System.out.println( (binaryStartSearch(linesAscending, point) + binaryFinishSearch(linesDescending, point) - linesAscending.length ) + " ");
        }

    }

    class Line {
        public int start;
        public int finish;

        public Line(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + finish + "]";
        }
    }

    int binaryStartSearch(Line[] array, int point){
        int l = 0;
        int r = array.length - 1;
        while (l<=r){

            int m = (l+r)/2;
            if (point == array[m].start){
                ++l;
            }
            else if (point > array[m].start){
                l = m +1 ;
            }
            else {
                r = m -1;
            }
        }
        return r  + 1;
    }

    int binaryFinishSearch(Line[] array, int point){
        int l = 0;
        int r = array.length - 1;
        while (l<=r){
            int m = (l+r)/2;
            if (point == array[m].finish){
               --r;
            }
            else if (point >= array[m].finish){
                l = m +1 ;
            }
            else {
                r = m -1;
            }
        }
        return array.length - r - 1;
    }
}
