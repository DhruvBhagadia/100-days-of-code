import java.util.*;

public class Women{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		// String inp = sc.nextLine();
		// String[] inps = inp.split(":");
		// int h1 = Integer.parseInt(inps[0]);
		// int m1 = Integer.parseInt(inps[1]);
		// inp = sc.nextLine();
		// inps = inp.split(":");
		// int h2 = Integer.parseInt(inps[0]);
		// int m2 = Integer.parseInt(inps[1]);
		// int t1 = (h1*60)+m1;
		// int t2 = (h2*60)+m2;
		// int ans = t2-t1;
		// ans = ans/2;
		// // System.out.println("a: "+ans);
		// int h3 = h1 + (ans/60);
		// int m3 = m1 + (ans%60);
		// if(m3 >= 60){
		// 	m3 = m3%60;
		// 	h3++;
		// }
		// String h = Integer.toString(h3);
		// String m = Integer.toString(m3);
		// if(Integer.parseInt(h)/10 == 0)
		// 	h = "0" + h;
		// if(Integer.parseInt(m)/10 == 0)
		// 	m = "0" + m;
		// // String finale = ;
		// System.out.println(h+":"+m);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
			arrlist.add(sc.nextInt());
		Collections.sort(arrlist);
		int max = arrlist.get(n-1) + arrlist.get(n-2);
		// System.out.println(max);
		for(int i=k; i<=max; i+=k)
			factors.add(i);
		int ans = 0;
		// System.out.println(Arrays.toString(arrlist.toArray()));
		// System.out.println(Arrays.toString(factors.toArray()));
		for(int i=0; i<factors.size(); i++){
			int current_factor = factors.get(i);
			int beg = 0;
			int end = arrlist.size()-1;
			while(beg < end){
				// int first = ;
				// int second = ;
				int sum = arrlist.get(beg) + arrlist.get(end);
				if(sum == current_factor){
					ans += 2;
					arrlist.remove(beg);
					arrlist.remove(end-1);
					break;
				}
				else if(sum > current_factor)
					end--;
				else
					beg++;
			}
		}
		// for(int i=0; i<arrlist.size(); ){
		// 	int current = arrlist.get(i);
		// 	Boolean found = false;
		// 	for(int j=i+1; j<arrlist.size(); j++){
		// 		// System.out.println(j + " " + arrlist.size());
		// 		if((current+arrlist.get(j))%k == 0){
		// 			ans += 2;
		// 			found = true;
		// 			arrlist.remove(i);
		// 			arrlist.remove(j-1);
		// 			break;
		// 		}
		// 	}
		// 	// if(arrlist.size() == 0)
		// 	// 	break;
		// 	if(!found)
		// 		i++;
		// }
		System.out.println(ans);
	}
}