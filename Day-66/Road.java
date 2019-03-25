import java.util.*;

class Road {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		sc.nextLine();
		while(test_cases-- != 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			int ans = Math.abs(n-m);
			if((n%2 == 0 && m%2 == 0) || (n%2 == 1 && m%2 == 1)){
				if(ans == 2)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else{
				if(ans == 1){
					int a=0;
					int b=0;
					if(m%2 == 0){
						a = n;
						b = m; 
					}
					else{
						a = m;
						b = n;
					}
					int i=(a-1)/2;
					int j=(b-2)/2;
					// System.out.println(i + " " + j);
					if(i == j)
						System.out.println("YES");
					else
						System.out.println("NO");
				}
				else
					System.out.println("NO");
			}
			// int ans = Math.abs(n-m);
			// if(ans == 1 || ans == 2)
			// 	System.out.println("YES");
			// else
			// 	System.out.println("NO");
			// int[] alice = new int[n];
			// int[] berta = new int[m];
			// HashSet<Integer> set = new HashSet<Integer>();
			// for(int i=0; i<n; i++)
			// 	alice[i] = sc.nextInt();
			// sc.nextLine();
			// for(int i=0; i<m; i++){
			// 	berta[i] = sc.nextInt();
			// 	set.add(berta[i]);
			// }
			// sc.nextLine();
			// int count = 0;
			// for(int i=0; i<n; i++)
			// 	if(set.contains(alice[i]))
			// 		count++;
			// System.out.println(count);
		}
	}
}