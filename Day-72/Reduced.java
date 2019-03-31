/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Reduced {
	public static int binarySearch(int[] arr, int el){
		for(int i=0; i<arr.length; i++)
			if(arr[i] == el)
				return i;
		return -1;
	}

	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
		    int t = sc.nextInt();
		    sc.nextLine();
		    while(t-- != 0){
		        int n = sc.nextInt();
		        sc.nextLine();
		        int[] arr = new int[n];
		        int[] dup = new int[n];
		        int[] ans = new int[n];
		        for(int i=0; i<n; i++){
		            arr[i] = sc.nextInt();
		            dup[i] = arr[i];
		        }
		        if(sc.hasNextLine())
		            sc.nextLine();
		        Arrays.sort(dup);
		        // System.out.println(Arrays.toString(arr));
		        // System.out.println(Arrays.toString(dup));
		        for(int i=0; i<n; i++){
		            int current = dup[i];
		            int index = binarySearch(arr, current);
		        	// System.out.println(index);
		            ans[index] = i;
		        }
		        for(int i=0; i<n; i++)
		        	System.out.print(ans[i] + " ");
		        System.out.println();
		        // System.out.println(Arrays.toString(ans));
		    }
		}
	}
}