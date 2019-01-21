import java.util.*;
import java.lang.*;

class King {
	public static void main(String args[]){
		Scanner sc = new  Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				sc.nextLine();
				int r = sc.nextInt();
				int c = sc.nextInt();
				int k = sc.nextInt();
				int y = Math.abs((Math.min(c+k, 8)-Math.max(1, c-k)+1));
				int x = Math.abs((Math.min(r+k, 8)-Math.max(1, r-k)+1));
				System.out.println(x*y);
			}
		}
	}
}