import java.util.*;

class MinDist{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int x = sc.nextInt();
				sc.nextLine();
				int i = 1;
				int prev = 0;
				int k = 2;
				int count = 0;
				while(i < x){
					prev = i;
					count++;
					i += k;
					k++;
					// System.out.println(prev + " " + i + " " + k);
				}
				if(x == 1)
					System.out.println("1");
				else{
					int ans = 0;
					if((count+(x-prev)) < ((count+1)+(i-x)))
						ans = count+(x-prev);
					else
						ans = (count+1)+(i-x);
					System.out.println(ans);
				}
			}
		}
	}
}