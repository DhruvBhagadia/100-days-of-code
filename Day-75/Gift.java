import java.util.*;

class Gift{
	public static int mini(int[] arr){
		int min = arr[0];
		for(int i=1; i<arr.length; i++)
			if(arr[i] < min)
				min = arr[i];
		return min;
	}

	public static int maxi(int[] arr){
		int max = arr[0];
		for(int i=1; i<arr.length; i++)
			if(arr[i] > max)
				max = arr[i];
		return max;
	}

	public static int index(int[] arr, int el){
		for(int i=0; i<arr.length; i++)
			if(arr[i] == el)
				return i;
		return -1;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int r = sc.nextInt();
			int c = sc.nextInt();
			sc.nextLine();
			int[][] arr = new int[r][c];
			int[][] t = new int[c][r];
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					arr[i][j] = sc.nextInt();
					t[j][i] = arr[i][j];
				}
				sc.nextLine();
			}
			// for(int j=0; j<c; j++){
			// 	System.out.println(Arrays.toString(t[j]));
			// }
			if(r <= c){
				int i;
				for(i=0; i<r; i++){
					// System.out.println(mini(arr[i]));
					Boolean flag = false;
					int min = mini(arr[i]);
					int index = index(arr[i], min);
					// System.out.println("i: "+index);
					while(index != -1){
						int max = maxi(t[index]);
						if(min == max){
							System.out.println(min);
							flag = true;
							break;
						}
						arr[i][index] = -1;
						index = index(arr[i], min);
					}	
					if(flag)
						break;
				}
				if(i == r)
					System.out.println("GUESS");
			}
			else{
				int i;
				for(i=0; i<c; i++){
					// System.out.println(mini(arr[i]));
					Boolean flag = false;
					int max = maxi(t[i]);
					int index = index(t[i], max);
					// System.out.println("i: "+index);
					while(index != -1){
						int min = mini(arr[index]);
						if(min == max){
							System.out.println(min);
							flag = true;
							break;
						}
						t[i][index] = -1;
						index = index(t[i], max);
					}	
					if(flag)
						break;
				}
				if(i == r)
					System.out.println("GUESS");
			}
		}
		
		// int[] arr = new int[n];
		// HashSet<Integer> set = new HashSet<Integer>();
		// for(int i=0; i<n; i++){
		// 	int inp = sc.nextInt();
		// 	if(!set.contains(inp)){
		// 		arr[i] = inp;
		// 		set.add(inp);
		// 	}
		// 	// arr[i] = sc.nextInt();
		// }
		// Arrays.sort(arr);
		// System.out.println(arr[arr.length-2]);
	}
}