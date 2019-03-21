import java.util.*;

public class Operations{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		while(test_cases-- != 0){
			int n = sc.nextInt();
			int count = 0;
			while(n != 1){
				if(n%2 == 0)
					n = n/2;
				else 
					n--;
				count++;
			}
			System.out.println(++count);
		}
	}
}