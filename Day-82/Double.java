import java.io.*;
import java.util.*;

public class Double {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for(int i=0; i<inp.length(); i += 2)
            arrlist.add(Character.getNumericValue(inp.charAt(i)));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // String inp = sc.nextLine();
        for(int i=0; i<arrlist.size(); i++){
            Integer j = map.get(arrlist.get(i));
            map.put(arrlist.get(i), (j == null) ? 1: j+1);
        }
        System.out.println(map);
        Iterator it = map.entrySet().iterator();
        Boolean flag = false;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if((int)pair.getValue()%2 != 0){
                flag = true;
                break;
            }
            it.remove();
        }
        if(flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}