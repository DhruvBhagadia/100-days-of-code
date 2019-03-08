import java.util.*;

public class SelectionSort{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int ans = 0;
		for(int i=0; i<n; i++){
			int temp = arr[i];
			int index = i;
			for(int j=i; j<n; j++){
				if(arr[j] < temp){
					index = j;
					temp = arr[j];
				}
			}
			if(index != i){
				ans++;
				int t = arr[index];
				arr[index] = arr[i];
				arr[i] = t;
			}
		}
		System.out.println(ans);
	}
}