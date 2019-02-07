import java.util.*;

class MaxPair{
	public static void main(String args[]){
		//System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int d = sc.nextInt();
				sc.nextLine();
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				for(int i=0; i<n; i++)
					arrlist.add(sc.nextInt());
				int i=0; 
				int j=1;
				int sum = 0;
				Collections.sort(arrlist, Collections.reverseOrder());
				//System.out.println(i);
				while(i < n){
					//System.out.println(i);
					if(Math.abs(arrlist.get(i)-arrlist.get(j)) < d){
						sum += arrlist.get(i)+arrlist.get(j);
						i += 2;
						j = i+1;
					}
					else
						j++;
					if(j >= n){
						i++;
						j = i+1;
						if(j >= n)
							break;
					}
				}
				System.out.println(sum);
			}
		}
	}
}