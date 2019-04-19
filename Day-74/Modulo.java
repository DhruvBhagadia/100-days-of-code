import java.util.*;

class Modulo{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			int inp = sc.nextInt();
			if(!set.contains(inp)){
				arr[i] = inp;
				set.add(inp);
			}
			// arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[arr.length-2]);
	}
}