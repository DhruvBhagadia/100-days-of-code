import java.util.*;

class FebOne {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String s = sc.nextLine();
				int ans = 0;
				for(int i=0; i<s.length()-3; i++){
					if(s.charAt(i) == 'c' || s.charAt(i) == 'h' || s.charAt(i) == 'e' || s.charAt(i) == 'f'){
						HashSet<Character> h = new HashSet<Character>();
						h.add(s.charAt(i));
						h.add(s.charAt(i+1));
						h.add(s.charAt(i+2));
						h.add(s.charAt(i+3));
						// char one = s.charAt(i);
						// char two = s.charAt(i+1);
						// char three = s.charAt(i+2);
						// // char four = s.charAt(i+3);
						// ArrayList<Character> temp = new ArrayList<Character>();
						// temp.add(s.charAt(i));
						// temp.add(s.charAt(i+1));
						// temp.add(s.charAt(i+2));
						// temp.add(s.charAt(i+3));
						if(h.contains('c') && h.contains('h') && h.contains('e') && h.contains('f'))
							ans++;
					}
				}
				if(ans != 0)
					System.out.println("lovely " + ans);
				else
					System.out.println("normal");
			}
		}
	}
}