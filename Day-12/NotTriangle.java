import java.util.*;

class NotTriangle {
	public static void main (String[] args) throws java.lang.Exception{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
		    while(true){
			int n = sc.nextInt();
			if(n != 0){
				int[] arr = new int[n];
				for(int i=0; i<n; i++)
					arr[i] = sc.nextInt();
				Arrays.sort(arr);
				int behind = n-1;
				int dup = behind;
				int count=0;
				for(int i=0; i<(n-2); i++){
					for(int j=i+1; j<(n-1); j++){
						while(arr[i]+arr[j] < arr[behind]) {
							count++;
							behind--;
						}
						behind = dup;
					}
				}
				System.out.println(count);
			}
			else
				break;   
		}
	}
}
}