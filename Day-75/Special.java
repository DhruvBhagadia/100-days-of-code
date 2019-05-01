
import java.util.*;
import java.lang.*;
import java.io.*;

class Special {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- != 0){
		    String inp = sc.nextLine();
		    String temp = "";
		    for(int i=0; i<inp.length(); i++){
		        char ch = inp.charAt(i);
		        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
		            temp += Character.toString(ch);
		    }
		    StringBuilder strb = new StringBuilder(temp);
		    strb = strb.reverse();
		    int index = 0;
		    StringBuilder fina = new StringBuilder(inp);
		    for(int i=0; i<inp.length(); i++){
		        char ch = inp.charAt(i);
		        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
		            fina.setCharAt(i, strb.charAt(index++));
		    }
		    System.out.println(fina);
		}
	}
}