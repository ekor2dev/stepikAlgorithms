import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Line> array = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            array.add(new Line(start, finish));
        }
        ArrayList<Integer> result = getResult(array);
        System.out.println(result.size());
        for (Integer e: result){
            System.out.printf("%d ", e);
        }
    }

    private ArrayList<Integer> getResult(ArrayList<Line> array) {
        array.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.finish.compareTo(o2.finish);
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        result.add(array.get(0).finish);
        for (Line e : array) {
            if (!e.has(result.get(result.size() - 1))) {
                result.add(e.finish);
            }
        }
        return result;
    }


    class Line {
        Integer start;
        Integer finish;

        Line(Integer start, Integer finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", start, finish);
        }


        public boolean has(int n) {
            return n >= start && n <= finish;
        }



    }

}
