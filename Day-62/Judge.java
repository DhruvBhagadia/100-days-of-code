import java.util.*;

class Judge{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				int[] a = new int[n];
				int[] b = new int[n];
				for(int i=0; i<n; i++)
					a[i] = sc.nextInt();
				sc.nextLine();
				for(int i=0; i<n; i++)
					b[i] = sc.nextInt();
				sc.nextLine();
				Arrays.sort(a);
				Arrays.sort(b);
				int a_t = 0;
				int b_t = 0;
				for(int i=0; i<n-1; i++){
					a_t += a[i];
					b_t += b[i];
				}
				if(a_t == b_t)
					System.out.println("Draw");
				else if(a_t < b_t)
					System.out.println("Alice");
				else
					System.out.println("Bob");
			}
		}
	}
}