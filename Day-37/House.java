import java.util.*;

class House{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		// if(sc.hasNextInt()){
		// 	int test_cases = sc.nextInt();
		// 	sc.nextLine();
		// 	while(test_cases-- != 0){
				
		// 	}
		// }
		int end = 1000;
		int beg = 0;
		int prev = end;
		int mid = (end + beg)/2;
		while(true){ 
			System.out.println("? " + mid + " " + mid);
			System.out.flush();
			String reply = sc.nextLine();
			if(reply.equals("NO"))
				end = mid;
			if(reply.equals("YES"))
				beg = mid;
			if(mid == prev)
				break;
			else
				prev = mid;
			mid = (beg+end)/2;
		}
		int side = 2*mid;
		// int side = 4;
		int sq = side*side;
		// System.out.println("area of sq: " + sq);
		beg = side;
		end = 1000;
		prev = end;
		mid = (end + beg)/2;
		while(true){ 
			System.out.println("? 0 " + mid);
			System.out.flush();
			String reply = sc.nextLine();
			if(reply.equals("NO"))
				end = mid;
			if(reply.equals("YES"))
				beg = mid;
			if(mid == prev)
				break;
			else
				prev = mid;
			mid = (beg+end)/2;
		}
		int ht = mid-side;
		// int ht = 3;
		// System.out.println(ht);
		beg = (side/2);
		end = 1000;
		prev = end;
		mid = (end + beg)/2;
		while(true){ 
			System.out.println("? " + side + " " + mid);
			System.out.flush();
			String reply = sc.nextLine();
			if(reply.equals("NO"))
				end = mid;
			if(reply.equals("YES"))
				beg = mid;
			if(mid == prev)
				break;
			else
				prev = mid;
			mid = (beg+end)/2;
		}
		int base = 2*mid;
		// System.out.println((base*ht)/2);
		int area = (base*ht)/2 + sq;
		System.out.println("! " + area);
	}
}