import java.util.*;

class Cook {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int count = 0;
				for(int i=0; i<5; i++){
					if(sc.nextInt() == 1)
						count++;
				}
				if(count == 0)
					System.out.println("Beginner");
				else if(count == 1)
					System.out.println("Junior Developer");
				else if(count == 2)
					System.out.println("Middle Developer");
				else if(count == 3)
					System.out.println("Senior Developer");
				else if(count == 4)
					System.out.println("Hacker");
				else if(count == 5)
					System.out.println("Jeff Dean");
				sc.nextLine();
			}
		}
	}
}