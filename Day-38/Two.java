import java.util.*;

class Two{
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
				long min_p = Collections.min(p);
				long min_q = Collections.min(q);
				int index = 0;
				if(min_p < min_q)
					index = p.indexOf(min_p);
				else
					index = q.indexOf(min_q);
				// sc.nextLine();

				ArrayList<Long> arrlist = new ArrayList<Long>();
				long first = a[index];
				for(int j=0; j <= p.get(index); j++){
						arrlist.add(first+j);
				}
				for(long j=1; j <= q.get(index); j++){
					arrlist.add(first-j);
				}
				// System.out.println(Arrays.toString(arrlist.toArray()));

				for(int j=0; j<arrlist.size();){
					long ele = arrlist.get(j);
					int i=0;
					for(; i<n; i++){
						if(i != index){
							long current = a[i];
							if(current > ele){
								long sub = current-ele;
								if(sub > q.get(i)){
									arrlist.remove(ele);
									break;
								}
							}
							else{
								long added = ele-current;
								if(added > p.get(i)){
									arrlist.remove(ele);
									break;
								}
							}
						}
					}
					if(i == n)
						j++;
				}
				System.out.println(arrlist.size());
			}
		}
	}
}