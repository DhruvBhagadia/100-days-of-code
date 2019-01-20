import java.util.*;

class King {
	static ArrayList<Integer> row = new ArrayList<Integer>();
	static ArrayList<Integer> column = new ArrayList<Integer>();

	public static int getMoves(int r, int c){
		if((r == 1 || r == 8) || (c == 1 || c == 8))
			return 6;
		else 
			return 9;
	}

	public static void addAllNeighboursOfCurrentToList(int r, int c){
		if(c+1 <= 8){
			row.add(r);
			column.add(c+1);
			if(r-1 >= 1){
				row.add(r-1);
				column.add(c+1);
			}
			if(r+1 <= 8){
				row.add(r+1);
				column.add(c+1);
			}
		}
		if(c-1 >= 1){
			row.add(r);
			column.add(c-1);
			if(r-1 >= 1){
				row.add(r-1);
				column.add(c-1);
			}
			if(r+1 <= 8){
				row.add(r+1);
				column.add(c-1);
			}
		}
		if(r-1 >= 1){
			row.add(r-1);
			column.add(c);
		}
		if(r+1 <= 8){
			row.add(r-1);
			column.add(c);
		}
	}

	public static void main(String args[]){
		//System.out.println("hello");
		Scanner sc = new  Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				sc.nextLine();
				int r = sc.nextInt();
				int c = sc.nextInt();
				int k = sc.nextInt();
				int ans = 0;
				row.add(r);
				column.add(c);
					r = row.get(0);
					c = column.get(0);
					row.remove(0);
					column.remove(0);
					ans += getMoves(r, c);
					addAllNeighboursOfCurrentToList(r, c);
					while(true){
						k--;
						if(k == 0)
							break;
						int neighbours = row.size();
						while(neighbours-- != 0){
							r = row.get(0);
							c = column.get(0);
							row.remove(0);
							column.remove(0);
							ans += getMoves(r, c);
							addAllNeighboursOfCurrentToList(r, c);
						}
					}
				System.out.println(ans);
			}
		}
	}
}