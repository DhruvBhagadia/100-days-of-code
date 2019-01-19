import java.util.*;

class BloodPrince {
	public static int getSequenceBefore(ArrayList<Integer> arrlist, int k, int j){
		if(j == 0){
			if(arrlist.get(j) <= k)
				return 1;
			else 
				return 0;
		}
		else{
			if(arrlist.get(j) <= k)
				return (1+getSequenceBefore(arrlist, k, j-1));
			else
				return (getSequenceBefore(arrlist, k, j-1));
		}
	}

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				System.out.println("hi");
				int n=5;
				int q=4;
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				arrlist.add(3);
				arrlist.add(2);
				arrlist.add(4);
				arrlist.add(1);
				arrlist.add(6);
				int sum = 0;
				for(int i=0; i<n; i++){
					System.out.println(sum);
					sum += getSequenceBefore(arrlist, 4, i);
				}
				System.out.println(sum);
			}
		}
	}
}