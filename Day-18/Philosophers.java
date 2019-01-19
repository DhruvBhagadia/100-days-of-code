import java.util.*;

class Philosophers {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				Boolean flag = false;
				for(int i=0; i<n; i++)
					arrlist.add(sc.nextInt());
				for(int i=0; i<n; i++){
					int current = arrlist.get(i);
					if(Collections.frequency(arrlist, current) >= 2){
						flag = true;
						System.out.println("yes");
						break;
					}
				}
				if(!flag)
					System.out.println("no");
			}
		}
	}
}