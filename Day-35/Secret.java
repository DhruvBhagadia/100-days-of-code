import java.util.*;

class Secret {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				int max = 0;
				String s = sc.nextLine();
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				HashMap<String, Integer> map2 = new HashMap<String, Integer>();
				ArrayList<String> strb = new ArrayList<String>();
				for(int i=0; i<s.length(); i++){
					String find = s.substring(0, i+1);
					int last = 0;
					int count = 0;
					while(last != -1){
					    last = s.indexOf(find,last);

					    if(last != -1){
					        count ++;
					        last += find.length();
					    }
					}
					if(count >= max){
						max = count;
						map2.put(find, find.length());
					}
					Integer j = map.get(find); 
            		map.put(find, count); 
				}
				// System.out.println(map);
				// System.out.println(max);
				// System.out.println(map2);
				int ma = 0;
				String ans = "";
				Iterator itr = map2.entrySet().iterator();
				while (itr.hasNext()) { 
		            Map.Entry ele = (Map.Entry)itr.next(); 
		            int o = (int) ele.getValue(); 
		            // System.out.println(ele.getKey() + ":" + o);
		            if(o > ma){
		            	ma = o;
		            	// System.out.println(max);
		            	ans = (String) ele.getKey();
		            }
		            itr.remove();
		        }
				System.out.println(ans);
			}
		}
	}
}