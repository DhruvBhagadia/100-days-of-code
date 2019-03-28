import java.util.*;

class Weird {
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int k = sc.nextInt();
					int n = sc.nextInt();
					// System.out.println(n + " " + k);
					// int k = sc.nextInt();
					// if(sc.hasNextLine())
					sc.nextLine();
					ArrayList<Integer> digits = new ArrayList<Integer>();
					while(k != 0){
						digits.add(k%10);
						k /= 10;
						// System.out.println(k);
					}
					if((digits.get(0) == digits.get(1)) && (digits.get(1) == digits.get(2)))
						System.out.println(1*1*1);
					else if((digits.get(0) == digits.get(1)) || (digits.get(1) == digits.get(2))
					 || (digits.get(2) == digits.get(0)))
						System.out.println(2*2*2);
					else
						System.out.println(3*3*3);
					// System.out.println(Arrays.toString(digits.toArray()));
				}
			}
		}
		catch(Exception e){

		}
	}
}