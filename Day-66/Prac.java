/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Prac
{   
    public static Boolean done(StringBuilder strb){
        for(int i=0; i<strb.length(); i++)
            if(strb.charAt(i) != '0')
                return false;
        return true;
    }
    
    public static StringBuilder reverseIt (StringBuilder strb){
    	for(int i=0; i<strb.length()/2; i++){
    		char a = strb.charAt(i);
    		strb.setCharAt(i, strb.charAt(strb.length()-i-1));
    		strb.setCharAt(strb.length()-i-1, a);
    	}
    	return strb;
    }

    public static String invert(StringBuilder strb){
        for(int i=0; i<strb.length(); i++){
            if(strb.charAt(i) == '0')
                strb.setCharAt(i, '1');
            else
                 strb.setCharAt(i, '0');
        }
        return strb.toString();
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder inp = new StringBuilder(sc.nextLine());
		int n = inp.length();
		int count = 0;
		// System.out.println(done(new StringBuilder("000000")));
		while(!done(inp)){
		    StringBuilder temp = new StringBuilder(inp);
		    // temp = reverseIt(temp);
		    temp.reverse();
		    // System.out.println("temp: " + temp);
		    int index = temp.indexOf("1");
		    // System.out.println("index: " + index);
		    int p_len = (n-index-1);
		    String t = inp.substring(0, p_len+1);
		    // System.out.println("t: " + t);
		    t = invert(new StringBuilder(t));
		    inp.replace(0, p_len+1, t);
		    count++;
		    // System.out.println("c: " + inp);
		    // if(count == 10)
		    // 	break;
		}
		   System.out.println(count);
	}
}
