import java.util.*;
import java.lang.*;
import java.io.*;

class ZigZag {
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3};
		Integer index = Arrays.asList(arr).indexOf(Collections.max(Arrays.asList(Arrays.copyOfRange(arr, 0, 3))));
		Integer temp = arr[1];
		arr[1] = arr[index];
		arr[index] = temp;
		for (int i=2; i<arr.length-1; i++) {
			if ((i%2 == 0) && (arr[i] > arr[i+1])) {
				Integer t = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = t;
			}
			else if((i%2 == 1) && (arr[i] < arr[i+1])){
				Integer t = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = t;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}