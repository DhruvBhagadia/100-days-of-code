//https://www.codechef.com/problems/OJUMPS

import java.util.*;
class Jumps {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		Long inp = sc.nextLong();
		if(inp < 0){
			System.out.println("no");
			return;
		}
		if(inp%6 == 0){
			System.out.println("yes");
			return;
		}
		Long q = inp/6;
		if((((6*q)+1) == inp) || (((6*q)+3) == inp))
			System.out.println("yes");
		else
			System.out.println("no");

	}
}