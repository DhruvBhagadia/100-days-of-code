import java.util.*;

class Watch{
	public static Boolean possibleToKeepAWatcher(StringBuilder inp, int index){
		if(index-1 < 0 && ((index+1 < inp.length() && inp.charAt(index+1) == '0')))
			return true;
		else if((index+1 >= inp.length()) && (index-1 >= 0 && inp.charAt(index-1) == '0'))
			return true;
		else if(((index-1 >= 0) && (inp.charAt(index-1) == '0')) && 
			((index+1 < inp.length()) && (inp.charAt(index+1) == '0')))
			return true;
		return false;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int count=0;
				sc.nextLine();
				StringBuilder inp = new StringBuilder(sc.nextLine());
				if(inp.length() == 1 && inp.charAt(0) == '0')
					System.out.println(1);
				else {
					for(int i=0; i<inp.length(); i++){
						if(!(inp.charAt(i) == '1') && possibleToKeepAWatcher(inp, i)){
							inp.setCharAt(i, '1');
							count++;
						}
					}
					System.out.println(count);
				}
			}	
		}
	}
}