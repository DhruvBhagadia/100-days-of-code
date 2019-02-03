import java.util.*;

class Pile{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				if(n%6 == 0)
					System.out.println("Misha");
				else
					System.out.println("Chef");
			}
			sc.close();
		}
	}
}