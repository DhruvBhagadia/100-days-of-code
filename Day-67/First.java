import java.util.*;

class First{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		while(test-- != 0){
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			String inp = sc.nextLine();
			String[] inps = inp.split(" ");
			for(int i=0; i<inps.length; i++)
				arrlist.add(Integer.parseInt(inps[i]));
			// while(sc.hasNextInt())
			// 	arrlist.add(sc.nextInt());
			// sc.nextLine();
			int n = arrlist.size();
			int index = arrlist.indexOf(n-1);
			arrlist.remove(index);
			int max = Collections.max(arrlist);
			System.out.println(max);
			arrlist.clear();
		}
	}
}