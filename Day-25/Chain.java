import java.util.*;

class Chain{
	public static String getFirst(int len){
		StringBuilder str = new StringBuilder();
		for(int i=0; i<len; i++){
			if(i%2 == 0)
				str.append("+");
			else
				str.append("-");
		}
		return str.toString();
	}

	public static String getSecond(int len){
		StringBuilder str = new StringBuilder();
		for(int i=0; i<len; i++){
			if(i%2 == 0)
				str.append("-");
			else
				str.append("+");
		}
		return str.toString();
	}

	public static int getAns(String ori, String der){
		int ans = 0;
		for(int i=0; i<ori.length();  i++){
			if(ori.charAt(i) != der.charAt(i))
				ans++;
		}
		return ans;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				String first = getFirst(inp.length());
				String second = getSecond(inp.length());
				int one = getAns(inp,  first);
				int two = getAns(inp, second);
				int ans = 0;;
				if(one < two)
					ans = one;
				else
					ans = two;
				System.out.println(ans);
			}
		}
	}
}