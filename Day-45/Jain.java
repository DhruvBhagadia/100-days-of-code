import java.util.*;

class Jain {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				ArrayList<String> arrlist = new ArrayList<String>();
				ArrayList<HashSet<Character>> setlist = new ArrayList<HashSet<Character>>();
				while(n-- != 0){
					arrlist.add(sc.nextLine());
				}
				for(String str:arrlist){
					HashSet<Character> set = new HashSet<Character>();
					for(int i=0; i<str.length(); i++)
						set.add(str.charAt(i));
					setlist.add(set);
				}
				int ans = 0;
				for(int i=0; i<setlist.size()-1; i++){
					for(int j=i+1; j<setlist.size(); j++){
						HashSet<Character> combined = new HashSet<Character>();
						combined.addAll(setlist.get(i));
						combined.addAll(setlist.get(j));
						if(combined.size() >= 5){
							if(combined.contains('a') && combined.contains('e') && combined.contains('i')
								&& combined.contains('o') && combined.contains('u'))
								ans++;
						}
					}
				}
				// for(int i=0; i<setlist.size(); i++)
				// 	System.out.println(setlist.get(i));
				// 	}
				System.out.println(ans);
			}
		}
	}
}