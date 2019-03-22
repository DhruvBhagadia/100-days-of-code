import java.util.*;

class Jumble {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        sc.nextLine();
        while(test_cases-- != 0){
            String inp = sc.nextLine();
            StringBuilder strb = new StringBuilder(inp);
            for(int i=0; i<strb.length(); ){
                char current = strb.charAt(i);
                if(current == 'A' || current == 'E' || current == 'I' 
                    || current == 'O' || current == 'U' || current == 'Y'
                    || current == 'a' || current == 'e' || current == 'i' || current == 'o'
                    || current == 'u' || current == 'y')
                    strb.deleteCharAt(i);
                else{
                    strb.insert(i, '.');
                    int temp = (int)current+32;
                    if(current >= 'A' && current <= 'Z')
                        strb.setCharAt(i+1, (char)temp);
                    i += 2;
                }
            }
            System.out.println(strb);
        }     
    }
}
