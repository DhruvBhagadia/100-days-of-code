import java.util.*;

class A1 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while(test_cases-- != 0){
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Integer> arrlist = new ArrayList<Integer>();
            for(int i=0; i<n; i++)
                arrlist.add(sc.nextInt());
            if(sc.hasNextLine())
                sc.nextLine();
            int min = Collections.min(arrlist);
            int i = arrlist.indexOf(min);
            Collections.reverse(arrlist);
            int max = Collections.max(arrlist);
            int j = arrlist.indexOf(max);
            j = n-1-j;
            System.out.println(min + " " + i + " " + max + " " + j);
            int ans = (max-min) + Math.abs(i-j);
            // int start = 0;
            // int end = n-1;
            // System.out.println(end + " " + (n-1));
            // while(start <= end){
            //     System.out.println(arrlist.get(start) + " " + arrlist.get(end));
            //     int ans = Math.abs(arrlist.get(start)-arrlist.get(end)) + Math.abs(start-end);
            //     if(ans > max)
            //         max = ans;
            //     start++;
            //     end--;
            // }
            System.out.println(ans);
        }     
    }
}
