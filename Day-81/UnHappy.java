import java.io.*;
import java.util.*;

public class UnHappy {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int balloons = sc.nextInt();
        int friends = sc.nextInt();
        sc.nextLine();
        if(friends >= balloons)
            System.out.println("YES");
        else{
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            String inp = sc.nextLine();
            for(int i=0; i<balloons; i++){
                Integer j = map.get(inp.charAt(i));
                map.put(inp.charAt(i), (j == null) ? 1: j+1);
            }
            Boolean flag = false;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if((int)pair.getValue() > friends){
                    flag = true;
                    break;
                }
                // System.out.println(pair.getKey() + " = " + );
                it.remove();
            }
            if(flag)
                System.out.println("NO");
            else
                System.out.println("YES");
            // System.out.println(map);
        }
    }
}