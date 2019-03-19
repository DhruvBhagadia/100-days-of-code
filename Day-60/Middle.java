import java.util.*;

public class Middle{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		String[] inps = inp.split(":");
		int h1 = Integer.parseInt(inps[0]);
		int m1 = Integer.parseInt(inps[1]);
		inp = sc.nextLine();
		inps = inp.split(":");
		int h2 = Integer.parseInt(inps[0]);
		int m2 = Integer.parseInt(inps[1]);
		int t1 = (h1*60)+m1;
		int t2 = (h2*60)+m2;
		int ans = t2-t1;
		ans = ans/2;
		// System.out.println("a: "+ans);
		int h3 = h1 + (ans/60);
		int m3 = m1 + (ans%60);
		if(m3 >= 60){
			m3 = m3%60;
			h3++;
		}
		String h = Integer.toString(h3);
		String m = Integer.toString(m3);
		if(Integer.parseInt(h)/10 == 0)
			h = "0" + h;
		if(Integer.parseInt(m)/10 == 0)
			m = "0" + m;
		// String finale = ;
		System.out.println(h+":"+m);
	}
}