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
				HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
				for(int i=0; i<n; i++){ 
					int ele = arrlist.get(i);
					if(!map.containsKey(ele)){
						ArrayList<Integer> positions = new ArrayList<Integer>();
						for(int kk=0; kk<n; kk++)
							if(arrlist.get(kk) == ele)
								positions.add(kk);
						map.put(ele, positions);
					}
				}
				// System.out.println(map);

				Iterator it = map.entrySet().iterator();
				ArrayList<Integer> ans = new ArrayList<Integer>();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        ArrayList<Integer> positions = (ArrayList<Integer>) pair.getValue();
			        int key = (int) pair.getKey();
			        // System.out.println(Arrays.toString(positions.toArray()));
			        if(positions.size() >= k){
			        	for(int i=0; i<=(positions.size()-k); i++){
			        		int beg = i;
							int end = i+(k-1);
							List<Integer> current = positions.subList(beg, end+1);
							int mid = (beg+end)/2;
							// System.out.println("b: " + beg + " e: " + end + " m: " + mid);
							int mid_ele = positions.get(mid);
							// ArrayList<Integer> prefix_sum = new ArrayList<Integer>(current);
							int term = mid_ele-(mid-beg);
							// for(int ii=0; ii < k; ii++)
							// 	prefix_sum.set(ii, term++);
							int total = 0;
							for(int ii=0; ii<k; ii++)
								total += Math.abs((term++)-current.get(ii));
							ans.add(total);
							//prefix sum for current
							//calculate cost
							//add to ans arraylist
							// System.out.println(Arrays.toString(current.toArray()));
							// System.out.println(Arrays.toString(prefix_sum.toArray()));
							// System.out.println(total);
			        	}
			        	// System.out.println(key);
			        	// System.out.println("ans: " + Arrays.toString(ans.toArray()));
			        }
			        it.remove();
			    }
			    if(ans.size() == 0)
			        System.out.println("-1");
			    else
			  		System.out.println(Collections.min(ans));
			}
		}
	}
}