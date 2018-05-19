import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
      //  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(reader.readLine());
        Point[] pSortedX = new Point[n];
        for (int i = 0; i < n; ++i) {
            String[] coordinates = reader.readLine().split(" ");
            pSortedX[i] = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }

        Arrays.sort(pSortedX, (o1, o2) -> Integer.compare(o1.x, o2.x));
        Point[] pSortedY = Arrays.copyOf(pSortedX, pSortedX.length);
        Arrays.sort(pSortedY, (o1, o2) -> Integer.compare(o1.y, o2.y));

        System.out.printf("%.9f", minDistance(pSortedX, pSortedY));
    }

    private double minDistance(Point[] pSortedX, Point[] pSortedY) {
        if (pSortedY.length == 2) {
            return pSortedY[0].distanceTo(pSortedY[1]);
        } else if (pSortedY.length == 3) {
            return Double.min(pSortedY[0].distanceTo(pSortedY[2]),
                    Double.min(pSortedY[0].distanceTo(pSortedY[1]), pSortedY[1].distanceTo(pSortedY[2])));
        }

        int midIndex = pSortedY.length/2;

        Point[] pSortedYLeft = new Point[midIndex];
        Point[] pSortedYRight = new Point[pSortedY.length - midIndex];
        Point[] pSortedXLeft = Arrays.copyOfRange(pSortedX, 0, midIndex);
        Point[] pSortedXR = Arrays.copyOfRange(pSortedX, midIndex, pSortedX.length);

        HashSet<Point> leftXset = new HashSet<>();
        Collections.addAll(leftXset, pSortedXLeft);

        for (int i = 0, l = 0, r = 0; i < pSortedY.length; i++){
            if(leftXset.contains(pSortedY[i])){
                pSortedYLeft[l] = pSortedY[i];
                l++;
            }
            else{
                pSortedYRight[r] = pSortedY[i];
                r++;
            }
        }

        double d = Double.min(minDistance(pSortedXLeft, pSortedYLeft),
                minDistance(pSortedXR, pSortedYRight));

        ArrayList<Point> inTheMiddle = new ArrayList<>();
        double verticalLine = (pSortedX[midIndex - 1].x + pSortedX[midIndex].x) / 2.0;
        for (Point p : pSortedY) {
            if (p.xDistance(verticalLine) < d ) {
                inTheMiddle.add(p);
            }
        }
        for (int i = 0; i < inTheMiddle.size(); ++i) {
            for (int j = i + 1; j < inTheMiddle.size() && j - i <= 7; ++j) {
                d = Double.min(d, inTheMiddle.get(i).distanceTo(inTheMiddle.get(j)));
            }
        }
        return d;
    }

    class Point {
        final int x;
        final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private double distanceTo(Point other) {
            return Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2));
        }

        private double xDistance(double VertLine) {
            return Math.abs(VertLine - x);
        }

        @Override
        public String toString() {
            return String.format("(%d:%d)", x, y);
        }
    }
}
