import java.util.*;

class Rooks {
	public static int firstValidColumn(Boolean[] column){
		int i=0;
		for(; i<column.length; i++)
			if(!column[i])
				break;
		return i;
	}

	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					int k = sc.nextInt();
					int dup = k;
					sc.nextLine();
					Boolean[] placed = new Boolean[n];
					Arrays.fill(placed, false);
					Boolean[] column = new Boolean[n];
					Arrays.fill(column, false);
					ArrayList<String> ans = new ArrayList<String>();
					while(k-- != 0){
						int r = sc.nextInt();
						int c = sc.nextInt();
						sc.nextLine();
						placed[r-1] = true;
						column[c-1] = true;
					}
					System.out.print((n-dup) + " ");
					int r = 0;
					int c = 0;
					for(int i=0; i<(n-dup); i++){
						while(r<n && placed[r])
							r++;
						while(c<n && column[c])
							c++;
						r++;
						c++;
						System.out.print(r + " " + c + " ");
					}
					System.out.println();
				}
			}
		}
		catch(Exception e){

		}
	}
}