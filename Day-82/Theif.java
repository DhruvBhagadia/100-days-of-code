import java.io.*;
import java.util.*;

public class Theif {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            long test_cases = sc.nextLong();
            sc.nextLine();
            while(test_cases-- != 0){
                long n = sc.nextLong();
                sc.nextLine();
                ArrayList<Long> arrlist = new ArrayList<Long>();
                Boolean[] visited = new Boolean[(int)n];
                for(int i=0; i<n; i++){
                    arrlist.add(sc.nextLong());
                    visited[i] = false;
                }
                if(sc.hasNextLine())
                    sc.nextLine();
                long r=n-1, s=0, h=0, ts=0, th=0;
                int l=0;
                s++;
                ts = arrlist.get(l);
                visited[l] = true;
                if(!visited[(int)r]){
                    h++;
                    th = 2*arrlist.get((int)r);
                    visited[(int)r] = true;
                }
                while(true){
                    if(th < ts){
                        r--;
                        if(r < 0 || visited[(int)r])
                            break;
                        h++;
                        th += 2*arrlist.get((int)r);
                        visited[(int)r] = true;
                    }
                    else{
                        l++;
                        if(l >= n || visited[(int)l])
                            break;
                        s++;
                        ts += arrlist.get((int)l);
                        visited[(int)l] = true;
                    }
                }
                System.out.println(s + " " + h);
                if(h > s)
                    System.out.println("Henil");
                else if(s > h)
                    System.out.println("Sanjana");
                else if(s == h)
                    System.out.println("Tie");
                    
            }
        }
    }
}