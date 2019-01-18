import java.util.*;

class Appetizers{
	public static StringBuilder reverseStringBuilder(StringBuilder strb, int len){
		StringBuilder ans = new StringBuilder();
		for(int i=len; i >= 0; i--){
			ans = ans.append(strb.charAt(i));
		}
		return ans;
	}

	public static Integer getDecimalValue(String str) {
		return Integer.parseInt(str, 2);
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				String[] inps = inp.split(" ");
				int n = Integer.parseInt(inps[0]);
				String original_appetizer = inps[1];
				int len = (int) Math.pow(2, n);
				ArrayList<StringBuilder> binary = new ArrayList<StringBuilder>();
				char[] op = new char[len];

				for(int i=0; i<len; i++){
					String bin = Integer.toBinaryString(i);
					StringBuilder strb = new StringBuilder(bin);
					while(strb.length() != n){
						StringBuilder prefix = new StringBuilder("0");
						strb = prefix.append(strb);
					}
					binary.add(strb);
				}

				for(int i=0; i<len; i++){
					StringBuilder strb = reverseStringBuilder(binary.get(i), (n-1));
					op[getDecimalValue(strb.toString())] = original_appetizer.charAt(i);
				}
				System.out.println(String.valueOf(op));
			}
		}
	}
}