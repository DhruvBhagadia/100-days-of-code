import java.util.*;

class Elephant{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		if(test_cases > 0){
			while(test_cases-- != 0){
				int len = sc.nextInt();
				sc.nextLine();
				String buildings = sc.nextLine();
				if(len > 0 && buildings.length() == len){
					int[] arr = new int[len];
					for(int i=0; i<len; i++){
						if(buildings.charAt(i) == '1'){
							arr[i] = -1;
							if(i > 0)
								arr[i-1] = -1;
							if(i < len-1)
								arr[i+1] = -1;
						}
					}
					int count = 0;
					for(int i=0; i<len; i++){
						if(arr[i] == -1)
							count++;
					}
					System.out.println(len-count);
				}	
			}
		}
	}
}