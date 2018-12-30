//https://www.codechef.com/problems/NUMGAME2

import java.util.*;

class NumberGame{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t;
  		long n;
  		t=sc.nextInt();
 		for(int i=0;i<t;i++){
			n=sc.nextLong();
			if(n%4==1)
			System.out.println("ALICE");
			else
			System.out.println("BOB");	
		}
	}
}
