import java.util.*;

class Two{

     public static void main(String []args){
        // System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            sc.nextLine();
            while(t-- != 0){
                long a = sc.nextLong();
                long b = sc.nextLong();
                long n = sc.nextLong();
                if(sc.hasNextLine())
                    sc.nextLine();
                long count = 1;
                while(count <= n){
                    if(count%2 == 1)
                        a = a << 1;
                    else
                        b = b << 1;
                    count++;    
                }
                long ans = (Math.max(a, b)/Math.min(a, b));
                System.out.println(ans);
            }
        }
     }
}