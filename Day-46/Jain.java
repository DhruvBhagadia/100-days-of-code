import java.util.*;

class Pair implements Comparable<Pair>{
	HashSet<Character> set;
	Integer size;

	Pair(HashSet<Character> set, Integer size){
		this.set = set;
		this.size = size;
	}

	public Integer getSize(){
		return this.size;
	}

	@Override
    public int compareTo(Pair p) {
        return this.getSize().compareTo(p.getSize());
    }
}

class Jain {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				// ArrayList<String> arrlist = new ArrayList<String>();
				// ArrayList<HashSet<Character>> setlist = new ArrayList<HashSet<Character>>();
				// ArrayList<Integer> arrlist = new ArrayList<Integer>();
				ArrayList<Pair> arrlist = new ArrayList<Pair>();

				while(n-- != 0){
					String temp = sc.nextLine();
					HashSet<Character> set = new HashSet<Character>();
					for(int i=0; i<temp.length(); i++)
						set.add(temp.charAt(i));
					Pair p = new Pair(set, set.size());
					arrlist.add(p);
					// arrlist.add(set.size());
				}
				Collections.sort(arrlist);
				// for(int i=0; i<arrlist.size(); i++)
				// 	System.out.println(arrlist.get(i).size);
				// for(String str:arrlist){
				// 	HashSet<Character> set = new HashSet<Character>();
				// 	for(int i=0; i<str.length(); i++)
				// 		set.add(str.charAt(i));
				// 	setlist.add(set);
				// }
				int ans = 0;

				for(int i=0; i<arrlist.size(); i++){
					int j=arrlist.size()-1;
					while(j != i && arrlist.get(i).size+arrlist.get(j).size >= 5){
						HashSet<Character> combined = new HashSet<Character>();
						combined.addAll(arrlist.get(i).set);
						combined.addAll(arrlist.get(j).set);
							// if(combined.size() >= 5){
						if(combined.contains('a') && combined.contains('e') && combined.contains('i')
							&& combined.contains('o') && combined.contains('u'))
								ans++;
							// }
						j--;
					}
				}

				// for(int i=0; i<setlist.size()-1; i++){
				// 	for(int j=i+1; j<setlist.size(); j++){
				// 		if(setlist.get(i).size()+setlist.get(j).size() >= 5){
							// HashSet<Character> combined = new HashSet<Character>();
							// combined.addAll(setlist.get(i));
							// combined.addAll(setlist.get(j));
							// // if(combined.size() >= 5){
							// 	if(combined.contains('a') && combined.contains('e') && combined.contains('i')
							// 		&& combined.contains('o') && combined.contains('u'))
							// 		ans++;
							// // }
				// 		}
				// 	}
				// }
				// for(int i=0; i<setlist.size(); i++)
				// 	System.out.println(setlist.get(i));
				// 	}
				System.out.println(ans);
			}
		}
	}
}