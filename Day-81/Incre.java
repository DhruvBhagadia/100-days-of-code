import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Incre { 
	// public static float power(long one, long two) {
 //        float result = 1;
 //        while (two > 0) {
 //            if ((two & 1) == 1) {
 //                result *= one;        
 //            }
 //            two >>= 1;
 //            one *= one; 
 //        }
 //        return result;
 //    }

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long n = sc.nextLong();
				long k = sc.nextLong(); 
				sc.nextLine();
				if(n == 2){
					k = k-1;
					BigInteger b1 = BigInteger.valueOf(k);
					BigInteger b2 = BigInteger.valueOf(k+1);
					BigInteger b3 = BigInteger.valueOf(2);
					b1 = b1.multiply(b2);
					b1 = b1.divide(b3);
					b3 = BigInteger.valueOf(1000000007);
					b1 = b1.mod(b3);
					System.out.println(b1); 
				}
				else{
					BigInteger x = BigInteger.valueOf(k-1);
					BigInteger y = BigInteger.valueOf(n-1);
					BigInteger a = x.mod(y);
					BigInteger modu = BigInteger.valueOf(1000000007);
					BigInteger temp = BigInteger.valueOf(1000000007);
					BigInteger temp2 = BigInteger.valueOf(1000000007);
					BigInteger two = BigInteger.valueOf(2);
					temp = x.add(y);
					temp = temp.subtract(a);
					temp2 = x.add(a);
					temp = temp.multiply(temp2);
					temp2 = y.multiply(two);
					temp = temp.divide(temp2);
					temp = temp.mod(modu);
					System.out.println(temp);
				}
				// long sum = (long)(((((k%1000000007)*((k-1)%1000000007)))%1000000007)*0.5);
				// long sum2 = (long)(((k*(k-1))%1000000007)*0.5);
				// System.out.println(k);
				// while(k != 0){
				// 	sum += k;
				// 	k--;
				// 	// System.out.println(sum);
				// }
				// sum = sum%1000000007;
				// System.out.println(sum);
				// System.out.println(sum2);
				// float ans = power(k-1, 2);
				// System.out.println(ans);
				// ans = (float)((0.5*ans)+(0.5*(k-1)));
				// int ans1 = (int)(ans%1000000007);
				// // int ans = (int)((t*0.5) + ((k-1)%)*0.5);
				// System.out.println(ans1);
			}
		}
	}
}
//1000000000000000000