import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mod = scanner.nextInt();
        new Main().run(n, mod);
    }


    private void run(int a, int b){
        System.out.println(delimeter(a,b));
    }

    private int delimeter(int a, int b){
        if (a == 0){
            return b;
        }
        else if (b == 0){
            return  a;
        }
        else if (a >= b){
            return delimeter(a%b, b);
        }
        return delimeter(a, b%a);
    }
}
