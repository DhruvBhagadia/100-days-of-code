import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class GuessArray { 
	static class Pair{
		int a;
		int b;
		
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		// if(sc.hasNextInt()){
		// 	int test_cases = sc.nextInt();
		// 	sc.nextLine();
		// 	while(test_cases-- != 0){
		// 		int n = Integer.parseInt(sc.nextLine());
		// 		String inp = sc.nextLine();
		// 		if((inp.length() < 11) || (inp.length() == 11 && inp.charAt(0) != '8'))
		// 			System.out.println("NO");
		// 		else{
		// 			int len = inp.length()-11;
		// 			Boolean found = false;
		// 			for(int i=0; i<=len; i++){
		// 				if(inp.charAt(i) == '8'){
		// 					found = true;
		// 					break;
		// 				}
		// 			}
		// 			if(!found)
		// 				System.out.println("NO");
		// 			else
		// 				System.out.println("YES");
		// 		}
		// 	}
		// }
		int[] arr = {4, 8, 15, 16, 23, 42};
		int[] ans = new int[6];
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		HashMap<Integer, Pair> pair_with_their_multiplications = new HashMap<Integer, Pair>();
		for(int i:arr)
			set.add(i);
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				Pair p = new Pair(arr[i], arr[j]);
				Integer in = new Integer(arr[i]*arr[j]);
				pair_with_their_multiplications.put(in, p);
			}
		}
		System.out.println("? 1 1");
		System.out.flush();
		Integer inp = Integer.parseInt(sc.nextLine());
		int temp = (int) Math.sqrt(inp);
		ans[0] = temp;
		set.remove(temp);

		System.out.println("? 2 2");
		System.out.flush();
		inp = Integer.parseInt(sc.nextLine());
		temp = (int) Math.sqrt(inp);
		ans[1] = temp;
		set.remove(temp);

		System.out.println("? 3 4");
		System.out.flush();
		inp = Integer.parseInt(sc.nextLine());
		Pair p = pair_with_their_multiplications.get(inp);
		set2.add(p.a);
		set2.add(p.b);

		System.out.println("? 3 5");
		System.out.flush();
		inp = Integer.parseInt(sc.nextLine());
		p = pair_with_their_multiplications.get(inp);
		if(set2.contains(p.a)){
			ans[2] = p.a;
			ans[4] = p.b;
			set2.remove(p.a);
		}
		else{
			ans[2] = p.b;
			ans[4] = p.a;
			set2.remove(p.b);
		}
		Integer value = set2.toArray(new Integer[1])[0];
		ans[3] = value;
		set.remove(p.a);
		set.remove(p.b);
		set.remove(value);
		value = set.toArray(new Integer[1])[0];
		ans[5] = value;
		set.remove(value);
		System.out.print("! ");
		for(int i: ans)
			System.out.print(i + " ");
		System.out.println();
		System.out.flush();
		// System.out.println(set);		
	}
}