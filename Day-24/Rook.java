import java.util.*;

class Rook{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int k = sc.nextInt();
				sc.nextLine();
				int[][] board = new int[n][n];
				String[] ans = new String[2*n];
				int index = 0;
				int count = 0;
				for(int l=0; l<k; l++){
					int i = sc.nextInt();
					int j = sc.nextInt();
					sc.nextLine();
					board[i-1][j-1] = 1;
					for(int m=0; m<n; m++){
						board[i-1][m] = 1;
						board[m][j-1] = 1;
					}
				}
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						if(board[i][j] == 0){
							ans[index++] = Integer.toString(i+1);
							ans[index++] = Integer.toString(j+1);
							count++;
							for(int m=0; m<n; m++){
								board[i][m] = 1;
								board[m][j] = 1;
							}
						}
					}
				}
				System.out.print(count+" ");
				for(int i=0; i < ans.length && ans[i] != null; i++)
					System.out.print(ans[i] + " ");
				System.out.println();
			}
		}
	}
}