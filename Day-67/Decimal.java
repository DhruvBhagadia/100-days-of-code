import java.util.*;

class Decimal{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		String[] inps = inp.split(",");
		StringBuilder one = new StringBuilder(inps[0]);
		StringBuilder two = new StringBuilder(inps[1]);
		// one.reverse();
		// two.reverse();
		int first = Integer.parseInt(one.toString(), 2);
		int second = Integer.parseInt(two.toString(), 2);
		System.out.println(first + " " + second);
		// for(int i=0; i<one.length(); i++)
		// 	first += (Integer.parseInt(Character.toString(one.charAt(i)))*(int)Math.pow(2, i));
		// for(int i=0; i<two.length(); i++)
		// 	second += (Integer.parseInt(Character.toString(two.charAt(i)))*(int)Math.pow(2, i));
		int ans = first+second;
		System.out.println(ans);
		String an = Integer.toBinaryString(ans);
		System.out.println(an);
		// System.out.println()
	}
}