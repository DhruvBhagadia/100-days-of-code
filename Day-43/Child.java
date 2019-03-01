import java.util.*;

class Child{

	public static int find(String str, int start, int end, char ch){
		String subs = str.substring(start, end);
		return(subs.indexOf(ch));
	}

	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		int len = first.length();
		int j = 0;
		ArrayList<StringBuilder> arrlist = new ArrayList<StringBuilder>();
		for(int i=0; i<2; i++){
			StringBuilder strb = new StringBuilder();
			char current = first.charAt(i);
			System.out.println("current: " + current);
			int index = find(second, j, len, current);
			int temp = i+1;
			String one = first.substring(temp, len);
			while(one.length() != 0){
				strb.append(current);
				current = one.charAt(0);
				System.out.println("first: " + one);
				one = first.substring(++temp, len);
				String two = second.substring(index+1, len);
				System.out.println("two: " + two);
				index = find(two, 0, two.length(), current);
			}
			arrlist.add(strb);
			// for(StringBuilder strbu:arrlist)
				System.out.println(strb);
		}
	}
}