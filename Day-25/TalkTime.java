import java.util.*;

class TalkTime{
	public static void main(String args[]){
		//System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				double actual_rate = sc.nextDouble();
				int actual_mins = sc.nextInt();
				int n = sc.nextInt();
				sc.nextLine();
				double cost = (actual_rate*actual_mins);
				int ans = 0;
				while(n-- != 0){
					int months = sc.nextInt();
					double rate = sc.nextDouble();
					int start = sc.nextInt();
					sc.nextLine();
					double current_cost = ((1.0*start)/months) + (rate*actual_mins);
					if(current_cost < cost){
						current_cost = cost;
						ans++;
					}
				}
				System.out.println(ans);
			}
		}
	}
}