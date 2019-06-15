import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Money { 
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){ 
				int n = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> input = new  ArrayList<Integer>();
				ArrayList<Integer> after_xoring = new  ArrayList<Integer>();
				ArrayList<Integer> result = new  ArrayList<Integer>();
				int sum = 0;
				for(int i=0; i<n; i++){
					input.add(sc.nextInt());  
					sum += input.get(i); 
				}
				sc.nextLine();
				int k = sc.nextInt();
				sc.nextLine();
				int x = sc.nextInt();
				sc.nextLine();	
				for(int i=0; i<n; i++){
					after_xoring.add(input.get(i)^x);
					result.add(after_xoring.get(i)-input.get(i));
				}
				// System.out.println(Arrays.toString(input.toArray()));
				// System.out.println(Arrays.toString(after_xoring.toArray()));
				// System.out.println(Arrays.toString(result.toArray()));
				Collections.sort(result, Collections.reverseOrder());
				// System.out.println(Arrays.toString(result.toArray()));
				int i=0; 
				while(true){
					int temp = 0;
					for(; i<k; i++)
						temp += result.get(i);
					k += k;
					if(k > n)
						k -= k;
					// System.out.println("i"+i);
					// System.out.println("temp"+temp);
					if(temp > 0)
						sum += temp;
					else
						break;
				}
				// for(int i=0; i<n; i++)
				// 	System.out.println(input.get(i)^x);
				System.out.println(sum);
			}		
		}
	}
}