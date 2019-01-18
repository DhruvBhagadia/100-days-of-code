import java.util.*;	

class Code {
	public static int funct (int n,int k,int ans, String operator, int[] a) {
		if(k == 0)
            return ans;
		else if(operator.equals("XOR")){
			int m = a[0]^a[1];
			for(int j=2; j<n; j++){
				m = m^a[j];
			}
			if(k%2 == 0)
				ans = ans^0;
			else
				ans = ans^m;
		}
		else if(operator.equals("AND")){
			int m = a[0]&a[1];
			for(int j=2; j<n; j++){
				m = m&a[j];
			}
			ans = ans&m;
		}
		else if(operator.equals("OR")){
			int m = a[0]|a[1];
			for(int j=2; j<n; j++){
				m = m|a[j];
			}
			ans = ans|m;
		}
		return ans;
	}
	public static void main (String[] args) throws java.lang.Exception{
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