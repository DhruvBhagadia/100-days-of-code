import java.util.*;

class Number {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		sc.nextLine();
		while(test_cases-- != 0){
			int n = Integer.parseInt(sc.nextLine());
			int digit = n%10;
			if(digit == 0)
				System.out.println("0");
			else if(digit == 5)
				System.out.println("1");
			else
				System.out.println("-1");
		}
	}
}