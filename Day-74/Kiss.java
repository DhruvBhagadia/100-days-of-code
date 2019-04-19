import java.util.*;

class Kiss{
	public static long A(int n){
		if(n%2 == 0)
			return (long)(Math.pow(2, n/2));
		else
			return (long)(Math.pow(2, (n-1)/2));
	}

	public static long K(int n){
		if(n == 1)
			return 2;
		else 
			return (A(n)+K(n-1));
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			int test_cases = Integer.parseInt(sc.nextLine());
			while(test_cases-- != 0){
				int n = Integer.parseInt(sc.nextLine());
				long ans = K(n);
				long m = 1000000007;
				System.out.println(ans%m);
			}
		}
	}
}