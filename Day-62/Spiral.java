import java.util.*;

class Two{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int m = sc.nextInt();
				sc.nextLine();
				int[][] a = new int[n][m];
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++)
						a[i][j] = sc.nextInt();
					// sc.nextLine();
				}
				if(sc.hasNextLine())
					sc.nextLine();
				int start_row = 0;
				int start_column = 0;
				int end_row = n-1;
				int end_column = m-1;
				while(true){
					for(int i=start_column; i<=end_column; i++)
						System.out.print(a[start_row][i] + " ");
					start_row++;
					if(start_row > end_row)
						break;
					for(int i=start_row; i<=end_row; i++)
						System.out.print(a[i][end_column] + " ");
					end_column--;
					if(end_column < start_column)
						break;
					for(int i=end_column; i>=start_column; i--)
						System.out.print(a[end_row][i] + " ");
					end_row--;
					if(end_row < start_row)
						break;
					for(int i=end_row; i>=start_row; i--)
						System.out.print(a[i][start_column] + " ");
					start_column++;
					if(start_column > end_column)
						break;
				}
				System.out.println();
			}
			// System.out.println(start_row + " " + end_row + " " + start_column + " "  + end_column);
		}
	}
}