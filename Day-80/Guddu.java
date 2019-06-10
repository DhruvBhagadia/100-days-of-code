import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Guddu { 
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long n = sc.nextLong();
				sc.nextLine();
				StringBuilder str = new StringBuilder(Long.toString(n));
				long ans = 0;
				while(n != 0){
					ans += (n%10);
					n = n/10;
				}
				if(ans%10 == 0)
					str.append("0");
				else{
					ans = (10-(ans%10));
					str.append(Long.toString(ans));
				}
				// str.append("1");
				System.out.println(str);
			}
		}
	}
}