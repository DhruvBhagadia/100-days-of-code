import java.util.*;
import java.math.BigInteger;

class First{
	public static long gcd(long num1, long num2){
		// System.out.println(num1 + " " + num2);
		while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
            // System.out.println(num1 + " " + num2);
        }
        return num2;
	}

	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long ai = sc.nextLong();
				long di = sc.nextLong();
				long aj = sc.nextLong();
				long dj = sc.nextLong();
				if(sc.hasNextLine())
					sc.nextLine();
				long diff = Math.abs((aj-ai)+(dj-di));
				// BigInteger one = BigInteger.valueOf(Math.abs(di));
			 //    BigInteger two = BigInteger.valueOf(Math.abs(dj));
			 //    System.out.println(one.gcd(two));
			 //    BigInteger gcd = one.gcd(two);
			 //    System.out.println("l: " + gcd);
			    long ans = gcd(Math.abs(di), Math.abs(dj));
			    // long ans = gcd(14, 21);
			    // System.out.println("a: " + ans);
				if(diff%ans == 0)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}