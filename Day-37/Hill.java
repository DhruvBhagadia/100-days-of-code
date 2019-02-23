import java.util.*;

class Hill{
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int u = sc.nextInt();
				int d = sc.nextInt();
				sc.nextLine();
				int[] ht = new int[n];
				for(int i=0; i<n; i++)
					ht[i] = sc.nextInt();
				sc.nextLine();
				int[] diff = new int[n-1];
				int index = 1;
				Boolean used = false;
				for(int i=0; i<(n-1); i++)
					diff[i] = ht[i]-ht[i+1];
				for(int i=0; i<diff.length; i++){
					if(diff[i] == 0){
						// System.out.println("0");
						index++;
					}
					else if((diff[i] < 0) && (Math.abs(diff[i]) <= u)){
						index++;
						// System.out.println("-ve");
					}
					else if(diff[i] > 0){
						if(diff[i] <= d){
							// System.out.println("+ve1");
							index++;
						}
						else if(!used){
							// System.out.println("+ve2");
							used = true;
							index++;
						}
					}
					else
						break;
				}
				System.out.println(index);
			}
		}
	}
}