import java.util.*;

class Tuples {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				long n = sc.nextLong();
				long a = sc.nextLong();
				long b = sc.nextLong();
				long c = sc.nextLong();
				sc.nextLine();
				ArrayList<Long> arrlist = new ArrayList<Long>();
				for(long i=1; i*i<=n; i++){
					if(n%i == 0){
						if(n/i == i)
							arrlist.add(i);
						else{
							arrlist.add(i);
							arrlist.add(n/i);
						}
					}
				}
				int count = 0;
				Collections.sort(arrlist);
				for(int i=0; i<arrlist.size() && arrlist.get(i) <= a; i++){
					long q = (n/arrlist.get(i));
					for(int j=0; j<arrlist.size() && arrlist.get(j) <= b; j++){
						if(arrlist.get(i)*arrlist.get(j) > n)
							break;
						if(q%arrlist.get(j) == 0 && (q/arrlist.get(j)) <= c)
							count++;
					}
				}
				System.out.println(count);
			}
		}
	}
}