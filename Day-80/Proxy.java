import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Proxy { 
	static String inp;
	public static Boolean left(int i){
		if((inp.charAt(i-1) == 'P') || (inp.charAt(i-2) == 'P'))
			return true;
		else
			return false;
	}

	public static Boolean right(int i){
		if((inp.charAt(i+1) == 'P') || (inp.charAt(i+2) == 'P'))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				inp = sc.nextLine();
				int req = (int) Math.ceil(0.75*n);
				int actual_present = 0;
				int allowed_proxies = 0;
				for(int i=0; i<n; i++){
					if((i <= 1) || (i >= n-2)){
						if(inp.charAt(i) == 'P')
							actual_present++;
					}
					else{
						System.out.println("i:"+i);
						if(inp.charAt(i) == 'P')
							actual_present++;
						else if(left(i) && right(i))
							allowed_proxies++;
					}
				}
				System.out.println("req: " + req + " actual_present: " + actual_present + " allowed_proxies: " + allowed_proxies);
				if(actual_present >= req)
					System.out.println("0");
				else{
					req = req - actual_present;
					if(allowed_proxies >= req)
						System.out.println(req);
					else
						System.out.println("-1");
				}
			}
		}
	}
}