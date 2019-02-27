import java.util.*;

class Valid{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++){
			char current = str.charAt(i);
			Integer j = map.get(current);
			map.put(current, (j == null) ? 1 : j+1);
		}
		HashMap<Integer, Integer> occ = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
	    	int value = (int) pair.getValue();
			Integer j = occ.get(value);
			occ.put(value, (j == null) ? 1 : j+1);
			set.add(value);
	        it.remove();
	    }
	    System.out.println(occ);

	    if(set.size() > 2)
	    	System.out.println("NO");
	    else if(set.size() == 1)
	    	System.out.println("YES");
	    else{
	    	int[] k = new int[2];
	    	int[] v = new int[2];
	    	int i=0;
	    	it = occ.entrySet().iterator();
	    	while(it.hasNext()){
	    		Map.Entry pair = (Map.Entry)it.next();
	    		k[i] = (int) pair.getKey();
	    		v[i] = (int) pair.getValue();
	    		i++;
	    		it.remove(); 
	    	}
	    	Boolean flag = false;
	    	if(v[0] > v[1]){
	    		System.out.println("here");
	    		if((k[0] == 1) && (k[1] == 2 && v[1] == 1)){
	    			flag = true;
	    			System.out.println("YES");
	    		}
	    		else if(((Math.abs(k[0]-k[1]) == 1) && v[1] == 1) || (k[1] == 1 && v[1] == 1)){
	    			flag = true;
	    			System.out.println("YES");
	    		}
	    	}
	    	else{
	    		if((k[1] == 1) && (k[0] == 2 && v[0] == 1)){
	    			flag = true;
	    			System.out.println("YES");
	    		}
	    		else if(((Math.abs(k[0]-k[1]) == 1) && v[0] == 1) || (k[0] == 1 && v[0] == 1)){
	    			flag = true;
	    			System.out.println("YES");
	    		}
	    	}
	    	if(!flag)
	    		System.out.println("NO");
	    	// System.out.println(Arrays.toString(k));
	    	// System.out.println(Arrays.toString(v));
	    }
	    
		
		// System.out.println(set);
	}
}