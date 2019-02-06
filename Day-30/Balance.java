import java.util.*;
//AAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBCCCCCCCCCCDDDDDDDDDDDD
class Balance{
	public static Integer countChar(String str, char c){
	    int count = 0;
	    for(int i=0; i < str.length(); i++){
	        if(str.charAt(i) == c)
	            count++;
	    }
	    return count;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				HashMap<Integer, Integer> factor = new HashMap<Integer, Integer>();
				for(int i=1; i<=inp.length(); i++){
					if(inp.length()%i == 0)
						factor.put(i, inp.length()/i);
				}

				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for(int i=0; i<inp.length(); i++){
					Integer j = map.get(inp.charAt(i));
					if(j == null)
						map.put(inp.charAt(i), countChar(inp, inp.charAt(i)));
				}

				ArrayList<Integer> answers = new ArrayList<Integer>();
				Iterator it = factor.entrySet().iterator();
			    while (it.hasNext()) {

			        Map.Entry pair = (Map.Entry)it.next();
			        int elements = (int) pair.getKey();
			        int individual_score = (int) pair.getValue();
			        int[] distribution = new int[map.size()];
			        int temp=0;
			        if(elements <= 26){
			        	
				 		int index = 0;
				 		Iterator iter = map.entrySet().iterator();
				 		while (iter.hasNext()){
				 			Map.Entry p = (Map.Entry)iter.next();
				 			char current = (char) p.getKey();
				 			int current_occurence = (int) map.get(current);
				 			distribution[index++] = individual_score - current_occurence;
				 		}
	 					for(int i=0; i<distribution.length; i++){
	 						if(distribution[i] < 0)
	 							temp += Math.abs(distribution[i]);
	 					}

			        	if(map.size() > elements){
			        		HashMap<Character, Integer> clone = new HashMap<Character, Integer>(map);
			        		int diff = map.size() - elements;
			        		while(diff-- != 0){
			        			int min = Collections.min(clone.values());
								temp += min;
								Iterator it1 = clone.entrySet().iterator();
							    while (it1.hasNext()) {
							        Map.Entry pai = (Map.Entry)it1.next();
							        if((Integer) pai.getValue() == min){
							        	it1.remove();
							        	break;
							        }
							    }
			        		}
			        		answers.add(temp);
			        	}
			        	else{
			        		answers.add(temp);
			        	}
			        }
			    }

			    System.out.println(Collections.min(answers));
			}
		}
	}
}