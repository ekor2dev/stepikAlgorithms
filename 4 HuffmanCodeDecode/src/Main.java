import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        new Main().run();
    }

    private void run() throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
        int uniqueCount = s.nextInt();

        int totalCount = s.nextInt();
        String m = s.nextLine();
        Map<String, Character> codeMap = new HashMap<>();
        for (int i = 0; i < uniqueCount; ++i){
            m = s.nextLine();

            String[] tmp = m.split(": ");
            codeMap.put(tmp[1], tmp[0].charAt(0));
        }
        String codedString = s.next();
        StringBuilder result = new StringBuilder();

       for (int i = -1; i < codedString.length() -1;){
           String code = "";
           while (!codeMap.containsKey(code) && i < codedString.length() ){
               ++i;
               code += codedString.charAt(i);

               }
               result.append(codeMap.get(code));


       }
       System.out.println(result.toString());
    }
}
