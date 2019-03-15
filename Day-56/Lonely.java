import java.util.*;

class Lonely{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int a = 0;
		for(int i=0; i<n; i++)
			a ^= sc.nextInt();
		System.out.println(a);
	}
}