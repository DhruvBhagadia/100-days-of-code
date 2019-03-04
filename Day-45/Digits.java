import java.util.*;

class Digits {
	public static int voilation(StringBuilder in){
		for(int i=0; i<in.length()-1; i++){
			if(in.charAt(i) > in.charAt(i+1))
				return i;
		}
		return -1;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String str = sc.nextLine();
				String[] str_arr = str.split(" ");
				StringBuilder n = new StringBuilder(str_arr[0]);
				String d = str_arr[1];
				StringBuilder temp = new StringBuilder();

				while(true){
					temp = n;
					n.append(d);
					if(voilation(n) == -1){
						System.out.println(n.substring(0, n.length()-1));
						break;
					}
					else
						n.deleteCharAt(voilation(n));
				}
			}
		}
	}
}