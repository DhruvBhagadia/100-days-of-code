import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Matches { 
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long n = sc.nextLong();
				long m = sc.nextLong();
				long count = 0;
				sc.nextLine();
				// if(n == m)
				// 	System.out.println("Ari");
				if(n > m){
					long mod = n%m;
					if(mod == 0)
						System.out.println("Ari");
					else if(m%mod == 0)
						System.out.println("Rich");
					else
						System.out.println("Ari");
				}
				else{
					long mod = m%n;
					if(mod == 0)
						System.out.println("Ari");
					else if(n%mod == 0)
						System.out.println("Rich");
					else
						System.out.println("Ari");
				}
				// while(true){
				// 	if(n == m)
				// 		break;
				// 	if(n > m){
				// 		long d = n/m;
				// 		n -= (m*d);
				// 	}
				// 	else{
				// 		long d = m/n;
				// 		m -= (n*d);
				// 	}
				// 	if (n == 0 || m == 0) 
				// 		break;
				// 	count++;
				// }
				// if(count%2 == 0)
				// 	System.out.println("Ari");
				// else
				// 	System.out.println("Rich");
			}
		}
	}
}