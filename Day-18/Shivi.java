import java.util.*;

class Shivi {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int b = sc.nextInt();
				int a = sc.nextInt();
				long[] arr = new long[n];
				for(int i=0; i<n; i++)
					arr[i] = sc.nextLong();
				Arrays.sort(arr);
				double sum = 0.0;
				double max = 0.0;
				int diff = b-a;
				for(int i=0; i<diff; i++){
					for(int j=n-1; j>((n-1)-a-i); j--){
						sum += arr[j];
					}
					if((sum/(a+1)) > (max/(a+1))){
						max = sum;
						a = a+i;
					}
					sum = 0;
				}
				
				System.out.format("%.6f", max/a);
				System.out.println();
			}
		}
	}
}