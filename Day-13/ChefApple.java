import java.util.*;

class ChefApple {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				Set<Integer> set = new HashSet<>();
				for(int i=0; i<n; i++){
					int item = sc.nextInt();
					set.add(item);
				}
				System.out.println(set.size());
			}
		}
	}
}