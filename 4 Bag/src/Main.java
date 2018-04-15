import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().run();
    }

    private void run(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int size = s.nextInt();
        ArrayList<Item> bag = new ArrayList<>();
        for(int i = 0; i < n; ++i){
             bag.add(new Item(s.nextInt(), s.nextInt()));
        }
        Collections.sort(bag);
        double totalVolume = 0;
        double totalPrice = 0;
        int i = 0;
        while (totalVolume < size && i < bag.size()){
            totalVolume += bag.get(i).volume;
            totalPrice += bag.get(i).price;
            ++i;
        }
        if (totalVolume > size) {
            --i;
            totalPrice -= bag.get(i).price*(totalVolume - size)/bag.get(i).volume;
        }

        System.out.printf("%.3f", totalPrice);
    }

    class Item implements Comparable<Item>{
        int price;
        int volume;

        Item(int price, int volume){
            this.price = price;
            this.volume = volume;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare((double)o.price/o.volume, (double)price/volume);
        }
        @Override
        public String toString(){
            return ""+price;
        }

    }
}
