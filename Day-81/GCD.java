import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class GCD { 
	public static int gcd(int a, int b){ 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 

    public static int findGCD(ArrayList<Integer> arrlist, int n) { 
        int result = arrlist.get(0); 
        for (int i = 1; i < n; i++) 
            result = gcd(arrlist.get(i), result); 
  
        return result; 
    }
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){ 
				int n = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				HashSet<Integer> set = new HashSet<Integer>();
				for(int i=0; i<n; i++){
					int current = sc.nextInt();
					if(!set.contains(current)){
						arrlist.add(current);
						set.add(current);
					}
				}
				sc.nextLine();
				if(arrlist.size() == 1)
					System.out.println(arrlist.get(0) + arrlist.get(0));
				else{
				Collections.sort(arrlist, Collections.reverseOrder());
				int removed, result, sum, fina = 0;
				int siz = arrlist.size();
				// System.out.println(Arrays.toString(arrlist.toArray()));
				for(int i=0; i<siz; i++){
					removed = arrlist.remove(i);
					result = findGCD(arrlist, siz-1);
					arrlist.add(i, removed);
					Collections.sort(arrlist, Collections.reverseOrder());
					sum = result+removed;
					if(sum > fina)
						fina = sum;
					else
						break;
				}
				System.out.println(fina);
			}
				// for(int i=0; i<arrlist.size(); i++){
				// 	for(int j=i+1; j<arrlist.size(); j++){
				// 		for(int k=i; k<j; k++){
				// 			System.out.print(arrlist.get(k) + " ");
				// 		}
				// 		System.out.println();
				// 	}
				// }
			}
		}
	}
}