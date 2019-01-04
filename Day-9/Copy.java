import java.util.*;

class Copy {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				int len = sc.nextInt();
				sc.nextLine();
				String inp = sc.nextLine();
				String[] inps = inp.split(" ");
				int[] arr = new int[len];
				for (int i=0; i<len; i++) {
					arr[i] = Integer.parseInt(inps[i]);
				}
				int dup = 0;
				Arrays.sort(arr);
				int i=0;
				while(i < len-1){
					int j;
					for(j=i+1; j<len; j++){
						if(arr[i] == arr[j])
							dup++;
						else{
							i = j;
							break;
						}
					}
					if(j >= len)
						break;
				}
				System.out.println(len-dup);
			}
		}
	}
}