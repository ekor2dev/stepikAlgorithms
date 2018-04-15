import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; ++i) {
            String[] coordinates = reader.readLine().split(" ");

            points[i] = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        System.out.printf("%.9f", minDistance(points));
    }

    private double minDistance(Point[] points) {
        if (points.length == 2) {
            return points[0].distanceTo(points[1]);
        } else if (points.length == 3) {
            return Double.min(points[0].distanceTo(points[2]),
                    Double.min(points[0].distanceTo(points[1]), points[1].distanceTo(points[2])));
        }

        int half = points.length / 2;
        Point[] s1 = new Point[half];
        Point[] s2 = new Point[points.length - half];
        System.arraycopy(points, 0, s1, 0, half);
        System.arraycopy(points, half, s2, 0, points.length - half);
        double verticalLine = (s2[0].x + s1[half - 1].x) / 2.0;
        double d = Double.min(minDistance(s1), minDistance(s2));

        ArrayList<Point> inTheMiddle = new ArrayList<>();
        for (Point p : points) {
            if (p.xDistance(verticalLine) < d) {
                inTheMiddle.add(p);
            }
        }
        inTheMiddle.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });
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
