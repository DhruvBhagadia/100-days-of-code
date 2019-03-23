import java.util.*;

class Days {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while(test_cases-- != 0){
            String inp = sc.nextLine();
            String[] inps = inp.split(" ");
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put("sunday", 0);
            map.put("monday", 1);
            map.put("tuesday", 2);
            map.put("wednesday", 3);
            map.put("thursday", 4);
            map.put("friday", 5);
            map.put("saturday", 6);
            String[] days = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday" ,"saturday"};
            String start = inps[0];
            String end = inps[1];
            int l = Integer.parseInt(inps[2]);
            int h = Integer.parseInt(inps[3]);
            int a = 0;
            int b = map.get(start);
            int c = map.get(end);
            
        }     
    }
}
