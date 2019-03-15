import java.util.*;

class Pairs{
	public static Boolean used(ArrayList<Integer> arrlist, int inp){
		if(arrlist.contains(inp))
			return true;
		return false;
	}

	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int m = sc.nextInt();
				sc.nextLine();
				int i=0;
				int[][] arr = new int[m][2];
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				ArrayList<Integer> ans = new ArrayList<Integer>();
				while(i != m){
					arr[i][0] = sc.nextInt();
					arr[i][1] = sc.nextInt();
					i++;
				}	
				arrlist.add(arr[m-1][0]);
				arrlist.add(arr[m-1][1]);
				ans.add(m-1);
				for(int j=m-2; j>=0; j--){
					if((used(arrlist, arr[j][0])) || (used(arrlist, arr[j][1])))
						continue;
					else{
						ans.add(j);
						arrlist.add(arr[j][0]);
						arrlist.add(arr[j][1]);
					}
				}
				for(int j=ans.size()-1; j>=0; j--)
					System.out.print(ans.get(j) + " ");
				System.out.println();	
			}
		}
	}
}