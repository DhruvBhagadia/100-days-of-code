import java.util.*;

public class Game{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		Boolean flag = false;
		while(n < m){
			if(m%(n*2) == 0)
				n = n*2;
			else if(m%(n*3) == 0)
				n = n*3;
			else{
				flag = true;
				break;
			}
			count++;
			if(n == m)
				break;
			// System.out.println("c: " + count);
		}
		if(flag)
			System.out.println("-1");
		else
			System.out.println(count);
		// int n = sc.nextInt();
		// int k = sc.nextInt();
		// sc.nextLine();
		// ArrayList<Integer> arrlist = new ArrayList<Integer>();
		// ArrayList<Integer> factors = new ArrayList<Integer>();
		// for(int i=0; i<n; i++)
		// 	arrlist.add(sc.nextInt());
		// Collections.sort(arrlist);
		// int max = arrlist.get(n-1) + arrlist.get(n-2);
		// // System.out.println(max);
		// for(int i=k; i<=max; i+=k)
		// 	factors.add(i);
		// int ans = 0;
		// // System.out.println(Arrays.toString(arrlist.toArray()));
		// // System.out.println(Arrays.toString(factors.toArray()));
		// for(int i=0; i<factors.size(); i++){
		// 	int current_factor = factors.get(i);
		// 	int beg = 0;
		// 	int end = arrlist.size()-1;
		// 	while(beg < end){
		// 		// int first = ;
		// 		// int second = ;
		// 		int sum = arrlist.get(beg) + arrlist.get(end);
		// 		if(sum == current_factor){
		// 			ans += 2;
		// 			arrlist.remove(beg);
		// 			arrlist.remove(end-1);
		// 			break;
		// 		}
		// 		else if(sum > current_factor)
		// 			end--;
		// 		else
		// 			beg++;
		// 	}
		// }
		// // for(int i=0; i<arrlist.size(); ){
		// // 	int current = arrlist.get(i);
		// // 	Boolean found = false;
		// // 	for(int j=i+1; j<arrlist.size(); j++){
		// // 		// System.out.println(j + " " + arrlist.size());
		// // 		if((current+arrlist.get(j))%k == 0){
		// // 			ans += 2;
		// // 			found = true;
		// // 			arrlist.remove(i);
		// // 			arrlist.remove(j-1);
		// // 			break;
		// // 		}
		// // 	}
		// // 	// if(arrlist.size() == 0)
		// // 	// 	break;
		// // 	if(!found)
		// // 		i++;
		// // }
		// System.out.println(ans);
	}
}