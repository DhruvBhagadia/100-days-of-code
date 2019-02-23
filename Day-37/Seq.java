import java.util.*;

class Seq{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int k = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				for(int i=0; i<n; i++)
					arrlist.add(sc.nextInt());
				sc.nextLine();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				HashMap<Integer, Integer> cloned;
				for(int i=0; i<n; i++){
					Integer j = map.get(arrlist.get(i)); 
            		map.put(arrlist.get(i), (j==null ? 1 : j+1));
				}
				System.out.println(map);
				cloned = (HashMap<Integer, Integer>) map.clone();
				Iterator it = map.entrySet().iterator();
				int max = 0;
				int max_key = 0;
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        int value = (int) pair.getValue();
			        int key = (int) pair.getKey();
			        if(value > max){
			        	max = value;
			        	max_key = key;
			        }
			        it.remove();
			    }
			    System.out.println(max);
			    map = (HashMap<Integer, Integer>) cloned.clone();
			    if(max < k)
			    	System.out.println("-1");
			    else{
			    	it = map.entrySet().iterator();
			    	ArrayList<Integer> ans = new ArrayList<Integer>();
			    	while (it.hasNext()) {
				        Map.Entry pair = (Map.Entry)it.next();
				        int value = (int) pair.getValue();
				        if(value >= k){
				        	ArrayList<Integer> indices = new ArrayList<Integer>();
				        	int key = (int) pair.getKey();
				        	int index = arrlist.indexOf(key);
				        	while(index != -1){
				        		indices.add(index);
				        		arrlist.set(index, -1);
				        		index = arrlist.indexOf(key);
				        	}
				        	int swaps = 0;
				        	for(int i=0; i<indices.size()-1; i++){
				        		int temp = indices.get(i+1)-indices.get(i)-1;
				        		swaps += temp;
				        	}
				        	ans.add(swaps);
				        	System.out.println("here:" + swaps);
				        }
				        it.remove();
				    }
				    int final_ans = Collections.min(ans);
				    System.out.println(final_ans);
			    }
			}
		}
	}
}