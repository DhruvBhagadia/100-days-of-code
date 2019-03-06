import java.util.*;

class Child{

	public static int lcs(char[] A, char[] B, int n){
		int[][] arr = new int[n+1][n+1];
		for(int i=0; i<=n; i++){
			for(int j=0; j<=n; j++){
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				else if(A[i-1] == B[j-1])
					arr[i][j] = 1+arr[i-1][j-1];
				else
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
			}
		}
		return arr[n][n];
	}

	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		System.out.println(lcs(first.toCharArray(), second.toCharArray(), first.length()));
	}
}