import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }


    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        // Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Heap heap = new Heap(n);
        for (int i = 0; i < n; ++i) {
            String command = s.next();
            if (command.equals("Insert")) {
                int newElement = s.nextInt();
                heap.add(newElement);
            } else {
                if (heap.size == 0) {
                    System.out.println("null");
                    continue;
                }
                System.out.println(heap.extractMax());
            }
        }
    }

    class Heap {
        int[] items;
        int size;

        public Heap(int trueSize) {
            items = new int[trueSize];
        }

        void add(int newItem) {
            items[size] = newItem;
            ++size;

            int child = size - 1;
            int parent = (size - 1) / 2;
            while (child > 0 && items[child] > items[parent]) {
                int tmp = items[child];
                items[child] = items[parent];
                items[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        int extractMax() {

            --size;
            int result = items[0];
            items[0] = items[size];
            heapify(0);
            return result;
        }

        void heapify(int i) {
            int leftChild;
            int rightChild;
            int largestChild;

            while (true) {
                leftChild = 2 * i + 1;
                rightChild = 2 * i + 2;
                largestChild = i;
                if (leftChild < size && items[leftChild] > items[largestChild]) {
                    largestChild = leftChild;
                }
                if (rightChild < size && items[rightChild] > items[largestChild]) {
                    largestChild = rightChild;
                }
                if (largestChild == i) {
                    return;
                }
                int tmp = items[largestChild];
                items[largestChild] = items[i];
                items[i] = tmp;
                i = largestChild;
            }
        }
    }

}

