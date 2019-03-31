import java.util.*;

class Pogo {
	
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					int k = sc.nextInt();
					int max = Integer.MIN_VALUE;
					sc.nextLine();
					Integer[] arr = new Integer[n];
					for(int i=0; i<n; i++)
						arr[i] = sc.nextInt();
					sc.nextLine();
					Collections.reverse(Arrays.asList(arr));
					// System.out.println(Arrays.toString(arr));
					// System.out.println(max);
					for(int i=0; i<k; i++){
						int temp = arr[i];
						int j = i+k;
						while(j<n){
							if(temp > max)
								max = temp;
							temp = temp+arr[j];
							j = j+k;
						}
					}
					System.out.println(max);
				}
			}
		}
		catch(Exception e){

		}
	}
}