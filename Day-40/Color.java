import java.util.*;

class Color{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int i=0; i<n; i++){
					int ele = sc.nextInt();
					Integer j = map.get(ele); 
            		map.put(ele, (j==null ? 1 : j+1));
				}
				sc.nextLine();
				// System.out.println(map);
				int ans = 0;
				Iterator it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry)it.next();
					int value = (int) pair.getValue();
						ans += (value-1);
					it.remove();
			    }
			    System.out.println(ans);
			}
		}
	}
}