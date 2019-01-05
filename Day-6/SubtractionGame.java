import java.util.*;

class SubtractionGame {
	static Boolean allEqual(ArrayList<Integer> arrlist){
		for(int i=0; i<arrlist.size()-1; i++){
			if(arrlist.get(i) != arrlist.get(i+1))
				return false;
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int test_cases = sc.nextInt();
		while(test_cases-- != 0){
			int len = sc.nextInt();
			String[] inps = new String[len];
			sc.nextLine();
			String inp = sc.nextLine();
			inps = inp.split(" ");
			for(int i=0; i<len; i++){
				arrlist.add(Integer.parseInt(inps[i]));
			}
			while(true){
				if(allEqual(arrlist))
					break;
				int max = Collections.max(arrlist);
				int min = Collections.min(arrlist);
				int index = arrlist.indexOf(max);
				arrlist.set(index, max-min);
			}
			System.out.println(arrlist.get(0));
		}
	}
}