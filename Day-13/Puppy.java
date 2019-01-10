import java.util.*;

class Puppy{
	public static void main(String args[]) {
		//System.out.println("h");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a%2 == 0 || b%2 == 0)
					System.out.println("Tuzik");
				else
					System.out.println("Vanka");
			}
		}
	}
}