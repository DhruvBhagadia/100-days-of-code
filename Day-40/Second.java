import java.util.*;

class Second{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				ArrayList<Long> p = new ArrayList<Long>();
				ArrayList<Long> q = new ArrayList<Long>();
				long[] a = new long[n];
				for(int i=0; i<n; i++)
					a[i] = sc.nextLong();
				sc.nextLine();
				for(int i=0; i<n; i++)
					p.add(sc.nextLong());
				sc.nextLine();
				for(int i=0; i<n; i++)
					q.add(sc.nextLong());
				long min = a[0]-q.get(0);
				long max = a[0]+p.get(0);
				for(int i=1; i<n; i++){
					min = Math.max(min, a[i]-q.get(i));
					max = Math.min(max, a[i]+p.get(i));
				}
				System.out.println(Math.max((max-min)+1, 0));
			}
		}
	}
}