import java.util.*;

class Matrix{
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
					sc.nextLine();
					// a[i] = sc.nextLine().split(" ");
				}
				Boolean flag = false;
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++){
						int current = a[i][j];
						if(current == -1){
							int left, right, top, down = -1;
							if(i-1 >= 0 && j-1 >= 0)
								a[i][j] = Math.max(a[i-1][j], a[i][j-1]);
							else if(i-1 >= 0)
								a[i][j] = a[i-1][j];
							else if(j-1 >= 0)
								a[i][j] = a[i][j-1];
							// for(int ii=0; ii<n; ii++){
							// 	for(int jj=0; jj<m; jj++)
							// 		System.out.print(a[ii][jj] + " ");
							// 	System.out.println();
							// }
							// System.out.println("----------------");
							for(int k=j+1; k<m; k++){
								if(a[i][k] < a[i][j] && a[i][k] != -1){
									// System.out.println("yes: " + k + " " + j);
									flag = true;
									break;
								}
							}
						}
					}
					if(flag)
						break;
				}
				if(flag)
					System.out.println("-1");
				else{
					for(int i=0; i<n; i++){
						for(int j=0; j<m; j++)
							System.out.print(a[i][j] + " ");
						System.out.println();
					}
				}	
			}
		}
	}
}