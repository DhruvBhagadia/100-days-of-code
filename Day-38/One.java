import java.util.*;

class One{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<Character> chara = new ArrayList<Character>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++){
			if(chara.contains(str.charAt(i))){
				int index = chara.indexOf(str.charAt(i));
				count.set(index, count.get(index)+1);
			}
			else{
				chara.add(str.charAt(i));
				count.add(1);
			}
		}
		// System.out.println(Arrays.toString(chara.toArray()));
		// System.out.println(Arrays.toString(count.toArray()));

		ArrayList<Character> ans = new ArrayList<Character>();
		int max = Collections.max(count);
		int index = count.indexOf(max);
		while(index != -1){
			ans.add(chara.get(index));
			count.set(index, -1);
			index = count.indexOf(max);
		}
		char final1 = Collections.min(ans);
		// System.out.println(Arrays.toString(ans.toArray()));
		System.out.println(final1);
	}
}