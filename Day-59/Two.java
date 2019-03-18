import java.util.*;

class Two{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String str = sc.nextLine();
				int n = str.length();
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				int max = 1;
				for (int i = 0; i < n; i++)  
		            for (int j = i+1; j <= n; j++)  {
		            	String temp = str.substring(i, j);
		            	Integer jj = map.get(temp);
		            	if(jj != null && jj+1 > max){
		            		max = jj+1;
		            	}
		            	map.put(temp, (jj == null ? 1 : jj+1));
		            }
		        System.out.println(map);
		        ArrayList<String> arrlist = new ArrayList<String>();
		        Iterator it = map.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if((Integer)pair.getValue() == max)
			        	arrlist.add((String) pair.getKey());
			        // System.out.println( + " = " + );
			        it.remove();
			    }
		        // System.out.println(max);
		        Collections.sort(arrlist);
		        // System.out.println(Arrays.toString(arrlist.toArray()));
		        System.out.println(arrlist.get(0));
			}
		}
	}
}