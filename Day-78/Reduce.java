import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Reduce { 
	static HashMap<Long, Long> map;
	static long mod = 1000000007;
	public static long fact(long n){
		long ans = 1;
		if(n == 1 || n == 0)
			return 1;
		else if(map.containsKey(n))
			return map.get(n);
		else if(map.containsKey(n-1))
			ans = (n*map.get(n-1))%mod;
		else
			ans = (n*fact(n-1))%mod;
		map.put(n, ans);
		return ans;
	}

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		map = new HashMap<Long, Long>();
		if(sc.hasNextLine()){
			int test_cases = Integer.parseInt(sc.nextLine());
			while(test_cases-- != 0){
				long n = Long.parseLong(sc.nextLine());
				long ans = fact(n+1)-1;
				System.out.println(ans);
			}
		}
	}
}