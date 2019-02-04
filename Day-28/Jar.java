import java.util.*;
import java.math.*;

class Jar{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				long sum = 0;
				for(int i=0; i<n; i++)
					sum += (sc.nextLong()-1);
				sc.nextLine();
				System.out.println(sum+1);
			}	
		}
		sc.close();	
	}
}