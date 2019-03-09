import java.util.*;

public class Swaps{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int ans = 0;
		for(int i=0; i<n;){
			if(arr[i] != i+1){
				ans++;
				int t = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = t;
			}
			else
				i++;
		}
		System.out.println(ans);
	}
}