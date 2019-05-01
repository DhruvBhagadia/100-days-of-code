import java.util.*;
import java.lang.*;
import java.io.*;

class Triple {
	public static Boolean contain(List<List<Integer>> ans, List<Integer> t1){
		for(List<Integer> ele: ans)      
		    if(ele.equals(t1))
		    	return true;
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for (int i=0; i<=(arr.length-3); i++) {
			int sum=0-arr[i], left=i+1, right=arr.length-1;
			// System.out.println(sum + " " + left + " " + right);
			while(left < right){
				int temp = arr[left] + arr[right];
				if ((temp == sum) && (!contain(ans, Arrays.asList(arr[i], arr[left], arr[right])))) {
					ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
					while(left<right && arr[left]==arr[left+1]) left++;
					while(left<right && arr[right]==arr[right-1]) right--;
					left++; right--;
				}
				else if(temp > sum) right--;
				else left++;
			}
		}
		for(List<Integer> temp: ans)
			System.out.println(Arrays.toString(temp.toArray()));
	}
}