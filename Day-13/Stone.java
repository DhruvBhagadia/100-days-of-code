import java.util.*;

class Stone {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Long> arrlist = new ArrayList<Long>();
		for(int i=0; i<n; i++){
			arrlist.add(sc.nextLong());
		}
		if(k != 0){
			if(k%2 == 0)
				k=2;
			else
				k=1;
		}
		while(k-- != 0) {
			Long max = Collections.max(arrlist);
			for(int i=0; i<n; i++)
				arrlist.set(i, max-arrlist.get(i));
		}
		for(int i=0; i<n; i++) {
			System.out.print(arrlist.get(i) + " ");
		}
		System.out.println();
	}
}