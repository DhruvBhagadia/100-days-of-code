import java.util.*;
import java.lang.*;
import java.io.*;

class Riddle {
	public static void main(String[] args) {
		int n = 6;
		// Integer[] arr = {1, 2, 3, 5, 1, 13, 3};
		// Integer[] arr = {2, 6, 1, 12};
		Integer[] arr = {3, 5, 4, 7, 6, 2};
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=1; i<=arr.length; i++){
			ArrayList<Integer> t = new ArrayList<Integer>();
			int start = 0;
			int end = start+i;
			while((start < arr.length) && (arr.length-start>=i)){
				Integer[] temp = Arrays.copyOfRange(arr, start, end);
				t.add(Collections.min(Arrays.asList(temp)));
				start++;
				end = start+i;
			}
			System.out.println("t: "+Arrays.toString(t.toArray()));
			ans.add(Collections.max(t));
			System.out.println(Arrays.toString(ans.toArray()));
		}


		// char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		// int n = 2;
		// int max = 1;
		// int count = 0;
		// int ans = 0;
		// HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// for(int i=0; i<tasks.length; i++){
		// 	char current = tasks[i];
		// 	Integer j = map.get(current);
		// 	if(j != null && (j+1) > max)
		// 		max = j+1;
		// 	map.put(current, (j == null) ? 1: j+1);
		// }
		// Iterator it = map.entrySet().iterator();
	 //    while (it.hasNext()) {
	 //        Map.Entry pair = (Map.Entry)it.next();
	 //        if((int) pair.getValue() == max)
	 //        	count++;
	 //        it.remove();
	 //    }
	 //    int no_of_slots = max-1;
	 //    int empty_slots = no_of_slots*(n-(count-1));
	 //    int remaining_tasks = tasks.length-(max*count);
	 //    int idles = Math.max(0, empty_slots-remaining_tasks);
	 //    System.out.println(tasks.length+idles);
	}
}