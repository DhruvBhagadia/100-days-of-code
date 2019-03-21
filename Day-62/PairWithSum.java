import java.util.*;

public class PairWithSum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int req = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int l = 0;
		int r = n-1;
		while(l < r){
			if(arr[l] + arr[r] == req){
				System.out.println(arr[l] + " " + arr[r]);
				break;
			}
			else if(arr[l] + arr[r] > req)
				r--;
			else
				l++;
		}
		if(l >= r)
			System.out.println("Sorry mate!");
	}
}