import java.util.*;

class Tablet {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int budget = sc.nextInt();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				sc.nextLine();
				for(int i=0; i<n; i++){
					int w = sc.nextInt();
					int h = sc.nextInt();
					int p = sc.nextInt();
					sc.nextLine();
					if(p <= budget)
						arrlist.add(w*h);
				}
				if(arrlist.size() == 0)
					System.out.println("no tablet");
				else
					System.out.println(Collections.max(arrlist));
			}
		}
	}
}