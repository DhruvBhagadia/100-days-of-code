import java.util.*;
 
class Substring {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while(test_cases-- != 0){
            String inp = sc.nextLine();
            int len = inp.length();
            int total = (len*(len+1)/2);
            int count = 0;
            int correct = (1 << ('a'-'a')) | (1 << ('b'-'a')) | (1 << ('c'-'a'));
            // System.out.println("correct: " + correct);
 
            for(int i=0; i<len-2; i++){
                for(int j=i+2; j<len; j++){
                    String sub = inp.substring(i, j+1);
                    int ans = 0;
                    for(int k=0; k<sub.length(); k++)
                        ans |= (1 << (sub.charAt(k)-'a'));
                    // System.out.println(sub + " " + ans);
                    if(ans == correct)
                        count++;
                }
            }
            // System.out.println(count);
            System.out.println(total-count);
        }
    }
}