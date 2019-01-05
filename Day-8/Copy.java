import java.util.*;

class Copy {
	public static void main(String args[]) {
		// Scanner sc=new Scanner(System.in);
		// int t,n;
		// t=sc.nextInt();
		// for(int i=0;i<t;i++){
		// 	n=sc.nextInt();
		// 	HashSet<Integer> hs=new HashSet<Integer>();
		// 	for(int j=0;j<n;j++)
		// 	hs.add(sc.nextInt());
		// 	System.out.println(hs.size());
		// }
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int len = sc.nextInt();
				sc.nextLine();
				String inp = sc.nextLine();
				String[] inps = inp.split(" ");
				int[] arr = new int[len];
				for (int i=0; i<len; i++) {
					arr[i] = Integer.parseInt(inps[i]);
				}
				int dup = 0;
				Arrays.sort(arr);
				for(int i=0; i<len-1; i++){
					for(int j=i+1; j<len; j++){
						if(arr[i] == arr[j])
							dup++;
						else
							break;
					}
				}
				System.out.println(len-dup);
			}
		}
	}
}