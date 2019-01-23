import java.util.*;

class Gf {
	public static double getAnswerForFirstStratergy(double t1_in_minutes, double t2_in_minutes, int dist){
		return (t1_in_minutes-t2_in_minutes)+dist;
	}

	public static double getAnswerForSecondStratergy(double t1_in_minutes, double t2_in_minutes, int dist){
		return Math.max((dist + t1_in_minutes - t2_in_minutes + dist) / 2.0, t1_in_minutes - t2_in_minutes);
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String t1 = sc.nextLine();
				String t2 = sc.nextLine();
				String[] strarr = t1.split(":");
				double t1_in_minutes = Integer.parseInt(strarr[0])*60+Integer.parseInt(strarr[1]);
				strarr = t2.split(":");
				double t2_in_minutes = Integer.parseInt(strarr[0])*60+Integer.parseInt(strarr[1]);
				int dist = sc.nextInt();
				sc.nextLine();
				double first = getAnswerForFirstStratergy(t1_in_minutes, t2_in_minutes, dist);
				double second = getAnswerForSecondStratergy(t1_in_minutes, t2_in_minutes, dist);
				System.out.println(first + " " + second);
			}
		}
	}
}