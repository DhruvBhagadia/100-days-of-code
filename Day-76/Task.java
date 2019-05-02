import java.util.*;
import java.lang.*;
import java.io.*;

class Task {
	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		int max = 1;
		int count = 0;
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<tasks.length; i++){
			char current = tasks[i];
			Integer j = map.get(current);
			if(j != null && (j+1) > max)
				max = j+1;
			map.put(current, (j == null) ? 1: j+1);
		}
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if((int) pair.getValue() == max)
	        	count++;
	        it.remove();
	    }
	    int no_of_slots = max-1;
	    int empty_slots = no_of_slots*(n-(count-1));
	    int remaining_tasks = tasks.length-(max*count);
	    int idles = Math.max(0, empty_slots-remaining_tasks);
	    System.out.println(tasks.length+idles);
	}
}