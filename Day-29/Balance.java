import java.util.*;
//AAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBCCCCCCCCCCDDDDDDDDDDDD
class Balance{
	public static Boolean isPrime(int n){
        for(int i = 2; i <= n/2; ++i)
            if(n % i == 0)
                return false;
        return true;
	}
	public static Integer countChar(String str, char c){
	    int count = 0;
	    for(int i=0; i < str.length(); i++){
	        if(str.charAt(i) == c)
	            count++;
	    }
	    return count;
	}
	public static Integer sumExceptMax(HashMap map){
	    int sum = 0;
	    int max = 0;
	    HashMap<Character, Integer> cloned = new HashMap<Character, Integer>(map);
	    Iterator it = cloned.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if((Integer) pair.getValue() > max)
	        	max = (Integer) pair.getValue();
	    }
	    it = cloned.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pair = (Map.Entry)it.next();
	    	if((Integer) pair.getValue() == max){
	    		it.remove();
	    		break;
	    	}
	    }
	    it = cloned.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pair = (Map.Entry)it.next();
	    	sum += (Integer) pair.getValue();
	    }
	    return sum;
	}
	public static Integer NormalMethod(HashSet<Character> h, HashMap<Character, Integer> map,
	 String inp, int ans){
	 	//if(inp.length()%h.size() == 0){
	 		int desired_term = inp.length()/h.size();
	 		//System.out.println(h.size());
	 		int[] distribution = new int[h.size()];
	 		int index = 0;
	 		Iterator iter = h.iterator();
	 		while (iter.hasNext()){
	 			char current = (char) iter.next();
	 			int current_occurence = (int) map.get(current);
	 			distribution[index++] = desired_term - current_occurence;
	 		}
	 		//System.out.println("dis: " + Arrays.toString(distribution));
	 		for(int i=0; i<distribution.length; i++)
	 			if(distribution[i] > 0)
	 				ans += distribution[i];
	 		return ans;
	 	//}
		
	}
	public static Integer BestFactor(HashSet<Character> h, HashMap<Character, Integer> map,
	 String inp){
	 	if(inp.length()%h.size() == 0)
	 		return(NormalMethod(h, map, inp, 0));
	 	else{
	 		ArrayList<Integer> answers = new ArrayList<Integer>();
	 		Boolean flag = false;
	 		int depth = 0;
	 		int tempLeft = 0;
	 		int tempRight = 0;
	 		char increase = 'a';
			int current_size = h.size();
			int left = current_size-1;
			int right = current_size+1;
			HashSet<Character> setLeft = new HashSet<Character>(h);
			HashSet<Character> setRight = new HashSet<Character>(h);
			HashMap<Character, Integer> mapLeft = new HashMap<Character, Integer>(map);
			HashMap<Character, Integer> mapRight = new HashMap<Character, Integer>(map);
			while(!flag){
				int min = Collections.min(mapLeft.values());
				tempLeft += min;
				Iterator it = mapLeft.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if((Integer) pair.getValue() == min){
			        	Character removed = (char) pair.getKey();
			        	setLeft.remove(removed);
			        	it.remove();
			        	break;
			        }
			    }
			    int temp = min;
			    min = Collections.min(mapLeft.values());
				it = mapLeft.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if((Integer) pair.getValue() == min){
			        	mapLeft.put((char) pair.getKey(), mapLeft.get(pair.getKey()) + temp);
			        	break;
			        }
			    }
			    // System.out.println(setLeft);
			    // System.out.println(mapLeft);
			    // System.out.println(tempLeft);
				if(inp.length()%left == 0){
					//System.out.println("LEFT");
					answers.add(NormalMethod(setLeft, mapLeft, inp, tempLeft));
					flag = true;
				}
				int max = Collections.max(mapRight.values());
				tempRight += 1;
				it = mapRight.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if((Integer) pair.getValue() == max){
			        	mapRight.put((char) pair.getKey(), mapRight.get(pair.getKey()) - 1);
			        	mapRight.put(increase, 1);
			        	setRight.add(increase++);
			        	break;
			        }
			    }
				if(inp.length()%right == 0){
					//System.out.println("RIGHT");
					answers.add(NormalMethod(setRight, mapRight, inp, tempRight));
					flag = true;
				}
				// System.out.println(setRight);
			 //    System.out.println(mapRight);
			 //    System.out.println(tempRight);
				left--;
				right++;
				//System.out.println("ans: " + Arrays.toString(answers.toArray()));
			}
			return Collections.min(answers);
	 	}	
	}
	public static Boolean isBalanced(String inp, HashMap<Character, Integer> map){
		Set<Integer> values = new HashSet<Integer>(map.values());
		return(values.size() == 1);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				//System.out.println("len: " + inp.length());
				HashSet<Character> h = new HashSet<Character>();
				for(int i=0; i<inp.length(); i++)
					h.add(inp.charAt(i));
				//System.out.println(h);
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for(int i=0; i<inp.length(); i++){
					Integer j = map.get(inp.charAt(i));
					if(j == null)
						map.put(inp.charAt(i), countChar(inp, inp.charAt(i)));
				}
				//System.out.println(map); 
				if(isBalanced(inp, map))
					System.out.println("0");
				else if(isPrime(inp.length())){
					int a = inp.length()-h.size(); //all unique
					int b = sumExceptMax(map); //all single character
					System.out.println(Math.min(a, b));
				}
				else{
					int a = inp.length()-h.size(); //all unique
					int b = sumExceptMax(map); //all single character
					int c = BestFactor(h, map, inp);
					//System.out.println(a);
					//System.out.println(b);
					//System.out.println(c);
					System.out.println(Math.min(a, Math.min(b, c)));
				}
			}
		}
		
		//NormalMethod(h, map, inp);
	}
}