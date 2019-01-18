import java.util.*;

class Code {
	public static int funct (int n,int k,int ans, String operator, int[] a) {
		if(operator.equals("XOR")){
			for(int i=0; i<k; i++) {
				for(int j=0; j<n; j++){
					ans = ans^a[j];
				}
			}
		}
		else if(operator.equals("AND")){
			for(int i=0; i<k; i++) {
				for(int j=0; j<n; j++){
					ans = ans&a[j];
				}
			}
		}
		else if(operator.equals("OR")){
			for(int i=0; i<k; i++) {
				for(int j=0; j<n; j++){
					ans = ans|a[j];
				}
			}
		}
		return ans;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int k = sc.nextInt();
				int ans = sc.nextInt();
				int[] a = new int[n];
				for(int i=0; i<n; i++)
					a[i] = sc.nextInt();
				sc.nextLine();
				String op = sc.nextLine();
				int ac = funct(n, k, ans, op, a);
				System.out.println(ac);
			}
		}
		
	}
}