import java.util.*;
import java.math.*;

class Appy{
	public static long gcd(long a, long b) {  
        BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.longValue(); 
    } 
    public static long lcm(long a, long b) { 
        return (a*b)/gcd(a, b); 
    } 
    public static long countDivisibles(long B, long M) { 
        long A=1;
        if (A % M == 0) 
            return (B / M) - (A / M) + 1; 
        return (B / M) - (A / M); 
    } 
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				String[] inps = inp.split(" ");
				long n = Long.parseLong(inps[0]);
				long a = Long.parseLong(inps[1]);
				long b = Long.parseLong(inps[2]);
				long k = Long.parseLong(inps[3]);	
				if((countDivisibles(n, a) + countDivisibles(n, b) - (2*countDivisibles(n, lcm(a,b)))) >= k)
					System.out.println("Win");
				else
					System.out.println("Lose");	
			}
		}
		
		sc.close();	
	}
}