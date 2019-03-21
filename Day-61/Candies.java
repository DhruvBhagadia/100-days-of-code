import java.util.*;

public class Candies{
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		while(test_cases-- != 0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			ArrayList<Integer> duplicate;
			for(int i=0; i<n; i++)
				arrlist.add(sc.nextInt());
				if(sc.hasNextLine())
			sc.nextLine();
			Collections.sort(arrlist);
			duplicate = (ArrayList<Integer>) arrlist.clone();
			int min = 0;
			for(int i=0; i<duplicate.size(); i++){
				min += duplicate.get(i);
				int dup = k;
				while(dup-- != 0){
				    if(duplicate.size() == 0)
				        break;
				    duplicate.remove(duplicate.size()-1);
				}
			}
			// System.out.println(min);
			duplicate = (ArrayList<Integer>) arrlist.clone();
			Collections.reverse(duplicate);
			int max = 0;
			for(int i=0; i<duplicate.size(); i++){
				max += duplicate.get(i);
				int dup = k;
				while(dup-- != 0){
				    if(duplicate.size() == 0)
				        break;
				    duplicate.remove(duplicate.size()-1);
				}
				// 	duplicate.remove(duplicate.size()-1);
			}
			System.out.println(min + " " + max);
		}
	
	}
}