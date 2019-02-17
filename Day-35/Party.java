import java.util.*;

class Party {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				for(int i=0; i<n; i++)
					arrlist.add(sc.nextInt());
				sc.nextLine();
				Collections.sort(arrlist);
				int present = 0;
				for(int i=0; i<n; i++){
					int current = arrlist.get(i);
					if(present >= current)
						present++;
				}	
				System.out.println(present);
			}
		}
	}
}