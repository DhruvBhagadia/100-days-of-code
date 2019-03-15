import java.util.*;

class Game{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		sc.nextLine();
		while(test_cases-- != 0){
			long n = sc.nextLong();
			sc.nextLine();
			int turn = 0;
			while(n != 1){
				if((n&(n-1)) == 0)
					n = n>>1;
				else{
					long p = n;
					// System.out.println("p: " + p);
					int count = 0;
					while(p != 0){
						count++;
						p = p>>1;
						// System.out.println("p: " + p);
					}
					long temp = 1<<(count-1);
				}
				turn++;
			}
			if(turn%2 != 0)
				System.out.println("Louise");
			else
				System.out.println("Richard");
		}
	}
}