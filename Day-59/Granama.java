import java.util.*;

class Granama{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				String[] inps = inp.split(" ");
				String first = inps[0];
				String second = inps[1];
				HashSet<Character> set1 = new HashSet<Character>();
				HashSet<Character> set2 = new HashSet<Character>();
				HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
				HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
				for(int i=0; i<first.length(); i++){
					set1.add(first.charAt(i));
					Integer j = map1.get(first.charAt(i));
					map1.put(first.charAt(i), (j == null) ? 1 : j+1);
				}
				for(int i=0; i<second.length(); i++){
					set2.add(second.charAt(i));
					Integer j = map2.get(second.charAt(i));
					map2.put(second.charAt(i), (j == null) ? 1 : j+1);
				}
				Boolean chef_guess = false;
				if(set1.containsAll(set2) && set2.containsAll(set1))
					chef_guess = true;
				Boolean actual = false;
				if(map1.equals(map2) && map2.equals(map1))
					actual = true;
				if((actual && chef_guess) || (!actual && !chef_guess))
					System.out.println("YES");
				else
					System.out.println("NO");
				// System.out.println(set1);
				// System.out.println(map1);
				// System.out.println(set2);
				// System.out.println(map2);
			}
		}
	}
}