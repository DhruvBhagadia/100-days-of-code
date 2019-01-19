import java.util.*;

class Sayan {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int rows_and_columns = sc.nextInt();
				int total_coins = sc.nextInt();
				int[] coins_in_row = new int[rows_and_columns];
				int[] coins_in_column = new int[rows_and_columns];
				int[][] array_holding_locations_of_coins = new int[rows_and_columns][rows_and_columns];
				for(int i=0; i<total_coins; i++){
					int row = sc.nextInt()-1;
					coins_in_row[row]++;
					int column = sc.nextInt()-1;
					coins_in_column[column]++;
					array_holding_locations_of_coins[row][column] = 1;
				}
				int mid = (total_coins)/2;
				int index = 0;
				int temp = 0;
				int row_partition = 0;
				int column_partition = 0;
				while(temp < mid){
					temp += coins_in_row[index++];
				}
				row_partition = index;
				index = 0;
				temp = 0;
				while(temp < mid){
					temp += coins_in_column[index++];
				}
				column_partition = index;
				ArrayList<Integer> coins_after_partition = new ArrayList<Integer>();
				int count = 0;
				for(int i=0; i<row_partition; i++){
					for(int j=0; j<column_partition; j++){
						if(array_holding_locations_of_coins[i][j] == 1)
							count++;
					}
				}
				coins_after_partition.add(count);
				count = 0;

				for(int i=row_partition; i<rows_and_columns; i++){
					for(int j=0; j<column_partition; j++){
						if(array_holding_locations_of_coins[i][j] == 1)
							count++;
					}
				}
				coins_after_partition.add(count);

				for(int i=0; i<row_partition; i++){
					for(int j=column_partition; j<rows_and_columns; j++){
						if(array_holding_locations_of_coins[i][j] == 1)
							count++;
					}
				}
				coins_after_partition.add(count);

				for(int i=row_partition; i<rows_and_columns; i++){
					for(int j=column_partition; j<rows_and_columns; j++){
						if(array_holding_locations_of_coins[i][j] == 1)
							count++;
					}
				}
				System.out.println(Collections.min(coins_after_partition));
			}
		}
	}
}