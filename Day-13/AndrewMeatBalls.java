import java.util.*;

class AndrewMeatBalls{
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					Long m = sc.nextLong();
					Long[] arr = new Long[n];
					for(int i=0; i<n; i++)
						arr[i] = sc.nextLong();
					Arrays.sort(arr, Collections.reverseOrder());
					Long sum=0L;
					int count=0;
					int i=0;
					while(sum < m && i < n){
						flag=true;
						count++;
						sum += arr[i++];
					}
					if(sum < m && i>= n)
						System.out.println("-1");
					else
						System.out.println(count);
				}
			}
		}catch(Exception e){

		}
	}
}