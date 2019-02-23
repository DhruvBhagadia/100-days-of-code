import java.util.*;

class Avg{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int k = sc.nextInt();
				int v = sc.nextInt();
				sc.nextLine();
				int sum = 0;
				for(int i=0; i<n; i++)
					sum += sc.nextInt();
				sc.nextLine();
				int a = (v*(n+k)-sum);
				if(a > 0){
					if(a%k == 0)
						System.out.println(a/k);
					else
						System.out.println("-1");
				}
				else
					System.out.println("-1");
			}
		}
	}
}