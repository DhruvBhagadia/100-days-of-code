import java.util.*;
 
class Palin {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while(test_cases-- != 0){
            String inp = sc.nextLine();
            int len = inp.length();
            int ca = sc.nextInt();
            int cb = sc.nextInt();
            int cost = 0;
            int min_cost = (ca < cb) ? ca: cb;
            Boolean flag = false;
            if(sc.hasNextLine())
                sc.nextLine();
            for(int i=0; i<(len/2); i++){
                char one = inp.charAt(i);
                char two = inp.charAt(len-i-1);
                // System.out.println(one + " " + two);
                if(one == '/' && two == '/')
                    cost += (2*min_cost);
                else if(one == '/' && two != '/')
                    cost += (two == 'a') ? ca: cb;
                else if(two == '/' && one != '/')
                    cost += (one == 'a') ? ca: cb;
                else if(two != '/' && one != '/'){
                    flag = (one != two) ? true: false;
                    if(flag)
                        break;
                }
                // System.out.println(cost);
            }
            if(flag)
                System.out.println("-1");
            else
                System.out.println(cost);
        }
    }
}