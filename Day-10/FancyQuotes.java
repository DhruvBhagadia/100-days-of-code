/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class FancyQuotes
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    Scanner sc = new Scanner(System.in);
    		if(sc.hasNextInt()){
    		    int test_cases = sc.nextInt();
        		sc.nextLine();
        		while(test_cases-- != 0){
        			Boolean ans = false;
        			String str = sc.nextLine();
        			String[] inp = str.split(" ");
        			if(Arrays.asList(inp).contains("not"))
        				System.out.println("Real Fancy");
        			else
        				System.out.println("regularly fancy");
        		}
    		}
		} catch(Exception e) {
		} 
	}
}
