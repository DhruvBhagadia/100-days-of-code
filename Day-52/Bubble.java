import java.util.*;

class Bubble{
	public static void main(String args[]){
		System.out.println("hello");
		int[] arr = {5, 4, 3, 2, 1};
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			for(int j=0; j<(n-i-1); j++){
				if(arr[j] > arr[j+1]){
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}