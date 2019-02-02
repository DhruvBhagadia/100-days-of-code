import java.util.*;
import java.math.*;

class Shield{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				int[] attacking_capacity = new int[n];
				int[] defencing_capacity = new int[n];
				for(int i=0; i<n; i++)
					attacking_capacity[i] = sc.nextInt();
				sc.nextLine();
				for(int i=0; i<n; i++)
					defencing_capacity[i] = sc.nextInt();
				sc.nextLine();
				boolean[] will_survive = new boolean[n];
				for(int i=0; i<n; i++)
					will_survive[i] = false;
				for(int i=0; i<n; i++){
					int left = i-1;
					int right = i+1;
					if(left < 0)
						left = n-1;
					if(right >= n)
						right = 0;
					int attacked = attacking_capacity[left] + attacking_capacity[right];
					if(defencing_capacity[i] > attacked)
						will_survive[i] = true;
				}
				int max = -1;
				for(int i=0; i<n; i++)
					if(will_survive[i] && (defencing_capacity[i] > max))
						max = defencing_capacity[i];
				System.out.println(max);
			}	
		}
		sc.close();	
	}
}