import java.util.*;

class Trick{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long a = sc.nextLong();
				sc.nextLine();
				ArrayList<Long> arrlist = new ArrayList<Long>();
				long current=1;
				long temp = 0;
				long profit = 0;
				while(true){
					profit = (long) ((a*current) - (Math.pow(2, current-1)+temp));
					temp = (long) (Math.pow(2, current-1)+temp);
					if(profit <= 0)
						break;
					arrlist.add(profit);
					current++;
				}
				current--;
				long value = Collections.max(arrlist);
				int d1 = arrlist.indexOf(value)+1;
				System.out.println(Arrays.toString(arrlist.toArray()));
				System.out.println(current + " " + d1);
			}
		}
	}
}