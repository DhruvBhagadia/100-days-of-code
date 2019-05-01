import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSubArray {
	public static void main (String[] args) {
		int[] arr = {8, -7, -3, 5, 6, -2, 3, -4, 2};
		int sum = Integer.MIN_VALUE;
		int temp = 0;
		for(int i=0; i<arr.length; i++){
			temp += arr[i];
			if(arr[i] > temp)
				temp = arr[i];
			if(temp > sum)
				sum = temp;
		}
		System.out.println(sum);
	}
}