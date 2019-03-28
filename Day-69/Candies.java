import java.util.*;

class Candies {
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					int m = sc.nextInt();
					int k = sc.nextInt();
					if(sc.hasNextLine())
						sc.nextLine();
					int temp = n%m;
					int ans = -1;
					if(m <= n && temp%k == 0)
						ans = temp/k;
					System.out.println(ans);
				}
			}
		}
		catch(Exception e){

		}
	}
}