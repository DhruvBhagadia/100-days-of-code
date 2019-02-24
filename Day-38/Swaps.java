import java.util.*;

class Swaps{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int k = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				for(int i=0; i<n; i++)
					arrlist.add(sc.nextInt());
				sc.nextLine();

				HashSet<Integer> set = new HashSet<Integer>(); 
				for(int i=0; i<arrlist.size(); i++)
					set.add(arrlist.get(i));
				Iterator iter = set.iterator();
				ArrayList<Integer> ans = new ArrayList<Integer>();
				while (iter.hasNext()) {
					int current = (int) iter.next();
					ArrayList<Integer> occ = new ArrayList<Integer>();
					System.out.print(current + ": ");
					for(int i=0; i<arrlist.size(); i++)
						if(arrlist.get(i) == current)
							occ.add(i);
					System.out.println(Arrays.toString(occ.toArray()));
					for(int i=0; i<=(occ.size()-k); i++){
						int beg = i;
						int end = i+(k-1);
						int mid = beg;
						if(k%2 == 0)
							mid = (beg+end)/2 + 1;
						else
							mid = (beg+end)/2;
						System.out.println(beg + " " + end + " " + mid);
						int sum = 0;
						while(beg <= end){
							if(beg != mid){
								System.out.println("here: " + (Math.abs(occ.get(beg)-occ.get(mid))-1)
								 + " sum: " + sum);
								sum += Math.abs(occ.get(beg)-occ.get(mid))-1;
							}
							beg++;
						}
						System.out.println("sum: " + sum);
						ans.add(sum);
					}
				}
				if(ans.size() == 0)
					ans.add(-1);
				System.out.println(Arrays.toString(ans.toArray()));
				System.out.println(Collections.min(ans));
			}
		}
	}
}