import java.util.*;

class Two{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test = Integer.parseInt(sc.nextLine());
		while(test-- != 0){
			int n = Integer.parseInt(sc.nextLine());
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = sc.nextInt();
			sc.nextLine();
			int count = 0;
			for(int i=0; i<n; i++){
				for(int j=i+1; j<n; j++){
					int a = arr[i]|arr[j];
					System.out.println(arr[i] + " " + arr[j] + " " + a + " " + Math.max(arr[i], arr[j]));
					if(a <= Math.max(arr[i], arr[j])) {
						count++;
						System.out.println("in");
					}
				}
			}
			System.out.println(count);
		}
	}
}