import java.util.*;
import java.math.*;

class Ingredient{
	public static Integer countChar(StringBuilder str, char c){
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
				int n = sc.nextInt();
				sc.nextLine();
				String[] inps = new String[n];
				ArrayList<HashSet<Character>> arrlist = new ArrayList<HashSet<Character>>();
				for(int i=0; i<n; i++){
					inps[i] = sc.nextLine();
					HashSet<Character> h = new HashSet<Character>();
					arrlist.add(h);
				}
				for(int i=0; i<n; i++){
					HashSet<Character> h = arrlist.get(i);
					for(int j=0; j<inps[i].length(); j++)
						h.add(inps[i].charAt(j));
				}
				StringBuilder strb = new StringBuilder();
				for(int i=0; i<n; i++){
					HashSet<Character> h = arrlist.get(i);
					Iterator iter = h.iterator();
					while (iter.hasNext()) {
					    strb.append(iter.next());
					}
				}
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for(int i=0; i<strb.length(); i++){
					Integer j = map.get(strb.charAt(i));
					if(j == null)
						map.put(strb.charAt(i), countChar(strb, strb.charAt(i)));
				}
				int ans = 0;
				Iterator it = map.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        if((int) pair.getValue() >= n)
			        	ans++;
			        it.remove();
			    }
				System.out.println(ans);
			}	
		}
		sc.close();	
	}
}