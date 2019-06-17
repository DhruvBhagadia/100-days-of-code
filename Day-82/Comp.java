import java.io.*;
import java.util.*;

public class Comp {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int test_cases = sc.nextInt();
            sc.nextLine();
            while(test_cases-- != 0){
                int n = sc.nextInt();
                int m = sc.nextInt();
                int x = sc.nextInt();
                sc.nextLine();
                ArrayList<Integer> comp = new ArrayList<Integer>();
                ArrayList<Integer> it = new ArrayList<Integer>();
                for(int i=0; i<n; i++)
                    comp.add(sc.nextInt());
                for(int i=0; i<m; i++)
                    it.add(sc.nextInt());
                if(sc.hasNextLine())
                    sc.nextLine();
                int c=0, i=0, count=0, sum=0;
                while(c<n && i<m){
                    if(comp.get(c) < it.get(i)){
                        if(sum+comp.get(c) > x)
                            break;
                        sum += comp.get(c);
                        c++;
                        count++;
                    }
                    else{
                        if(sum+it.get(i) > x)
                            break;
                        sum += it.get(i);
                        i++;
                        count++;
                    }
                }
                if(sum < x){
                    if(i >= m){
                        while(c<n && sum+comp.get(c) <= x){
                            sum += comp.get(c);
                            c++;
                            count++;
                        }
                    }
                    else{
                        while(i<m && sum+it.get(i) <= x){
                            sum += it.get(i);
                            i++;
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}