import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Signs { 
	static HashMap<Integer, Integer> map;

	public static int power(int one, int two) {
        int result = 1;
        while (two > 0) {
            if ((two & 1) == 1) {
                result = (int)(((long)result*one)%1000000007);        
            }
            two >>= 1;
            long t = ((long)one*one)%1000000007;
            one = (int)t; 
        }
        return result;
    }

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			map = new HashMap<Integer, Integer>();
			while(test_cases-- != 0){
				int k = sc.nextInt();
				sc.nextLine();
				int c = 0;
				if(map.containsKey(k-1)){
					long temp = map.get(k-1)*2;
					c = (int)(temp%1000000007);
				}
				else{
					int a = (int)(power(2, k-1)%1000000007);
					long temp = (long)a;
					long b = 10*temp;
					c = (int)(b%1000000007);
				}
				System.out.println(c);
				map.put(k, c);
			}
		}
	}
}