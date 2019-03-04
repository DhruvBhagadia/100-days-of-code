import java.util.*;

class Number {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			// sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				int neg = 0;
				int pos = 0;
				int max = 0;
				int min = 0;
				for(int i=0; i<n; i++){
					int inp = sc.nextInt();
					if(inp < 0)
						neg++;
					else
						pos++;
				}
				if(neg == 0){
					max = pos;
					min = pos;
				}
				else if(pos == 0){
					max = neg;
					min = neg;
				}
				else if(pos > neg){
					max = pos;
					min = neg;
				}
				else{
					max = neg;
					min = pos;
				}
				System.out.println(max + " " + min);
			}
		}
	}
}