import java.util.*;

class Segment {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		sc.nextLine();
		while(test_cases-- != 0){
			String str = sc.nextLine();
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			for(int i=0; i<str.length(); ){
				// System.out.println("i: " + i);
				if(str.charAt(i) == '1'){
					arrlist.add(i);
					while((i+1) < str.length() && str.charAt(i+1) == '1')
						i++;
					i++;
				}
				else
					i++;
			}
			if(arrlist.size() > 1 || arrlist.size() == 0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}