import java.util.*;

class Fatland {
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					if(sc.hasNextLine())
						sc.nextLine();
					ArrayList<Integer> sq = new ArrayList<Integer>();
					int temp = 1;
					while((temp*temp) <= n){
						sq.add(temp*temp);
						temp++;
					}
					// System.out.println(Arrays.toString(sq.toArray()));
					int count = 1;
					n -= sq.get(sq.size()-1);
					// System.out.println(n);
					while(n != 0){
						count++;
						int index = 0;
						while((index+1<sq.size()) && sq.get(index+1) <= n)
							index++;
						n -= sq.get(index);
					}
					System.out.println(count);
				}
			}
		}
		catch(Exception e){

		}
	}
}