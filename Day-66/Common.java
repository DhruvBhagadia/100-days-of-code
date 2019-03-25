import java.util.*;

class Common {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		sc.nextLine();
		while(test_cases-- != 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			int[] alice = new int[n];
			int[] berta = new int[m];
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0; i<n; i++)
				alice[i] = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<m; i++){
				berta[i] = sc.nextInt();
				set.add(berta[i]);
			}
			sc.nextLine();
			int count = 0;
			for(int i=0; i<n; i++)
				if(set.contains(alice[i]))
					count++;
			System.out.println(count);
		}
	}
}