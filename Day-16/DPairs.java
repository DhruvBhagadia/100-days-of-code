import java.util.*;

class DPairs {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> b = new ArrayList<Integer>();

			for(int i=0; i<n; i++){
				a.add(sc.nextInt());
			}
			for(int i=0; i<m; i++){
				b.add(sc.nextInt());
			}
			int min_index = 0;
			for(int i=1; i<n; i++)
				if(a.get(i) < a.get(min_index))
					min_index = i;
			for(int i=0; i<m; i++)
				System.out.println(min_index + " " + i);
			int max_index = 0;
			for(int i=1; i<m; i++)
				if(b.get(i) > b.get(max_index))
					max_index = i;
			for (int i=0; i<n; i++) {
				if(i == min_index){

				}
				else
					System.out.println(i + " " + max_index);
			}
		}
		
	}
}