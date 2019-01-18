import java.util.*;

class String1 {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String str = sc.nextLine();
				int ans = 0;
				for(int i=0; i<str.length(); i++){
					char current = str.charAt(i);
					if(current >= '0' && current <= '9'){
						int a = Character.getNumericValue(current);
						ans += a;
					}
				}
				System.out.println(ans);
			}
		}
	}
}