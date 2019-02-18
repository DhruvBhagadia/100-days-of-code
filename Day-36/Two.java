import java.util.*;

class Two {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				String s = sc.nextLine();
				ArrayList<String> str = new ArrayList<String>();
				ArrayList<Integer> occ = new ArrayList<Integer>();
				char ch = s.charAt(0);
				int co = 0;
				for(int i=0; i<s.length(); i++){
					String find = s.substring(0, i+1);
					if(s.charAt(i) == ch)
						co++;
					str.add(find);
            		occ.add(1); 
				}

				occ.set(0, co);
				String ans = str.get(0);
				int max_occ = occ.get(0);
				for(int i=1; i<str.size(); i++){
					String find = str.get(i);
					int last = 0;
					int count = 0;
					while(last != -1){
					    last = s.indexOf(find,last);

					    if(last != -1){
					        count ++;
					        last += find.length();
					    }
					}
					if(count < max_occ)
						break;
					else
						ans =  find;
				}
				// int last = 0;
				// 	int count = 0;
				// 	while(last != -1){
				// 	    last = s.indexOf(find,last);

				// 	    if(last != -1){
				// 	        count ++;
				// 	        last += find.length();
				// 	    }
				// 	}
				// 	if(count >= max){
				// 		max = count;
				// 		map2.put(find, find.length());
				// 	}
				// 	Integer j = map.get(find);

				// System.out.println(Arrays.toString(str.toArray()));
				// System.out.println(Arrays.toString(occ.toArray()));
				System.out.println(ans);
			}
		}
	}
}