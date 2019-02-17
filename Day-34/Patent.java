import java.util.Scanner;

class Patent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T -- > 0 ) 
		{
			int N = sc.nextInt(); int M = sc.nextInt();	int X = sc.nextInt(); int K = sc.nextInt();
			int even = 0 , odd = 0;
			sc.nextLine();
			String str = sc.next();
			char[] charArray = str.toCharArray();
			for(int i = 0 ; i < charArray.length; i++)
				if(charArray[i] == 'E') even ++;
				else	odd ++;
			for(int i = 1 ; i <= M && N > 0; i++)
				if(i % 2 == 0 && even > 0) {
					int diff = (even > X) ? X : even;
					even -= diff;
					N -= diff; 
				}
				else if(i % 2 != 0 && odd > 0) {
					int diff = (odd > X) ? X : odd;
					odd -= diff;
					N -= diff; 
				}
			String result = (N <=0 ) ? "yes":"no";
			System.out.println(result);
				
		}
		sc.close();
	}
}
