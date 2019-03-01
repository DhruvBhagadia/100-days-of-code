import java.util.*;

class Pair {
	char c;
	int count;
	Pair(char c, int count){
		this.c = c;
		this.count = count;
	}
}

class SpecialPalindrome{
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			ArrayList<Pair> arrlist = new ArrayList<Pair>();
			for(int i=0; i<n; ){
				char current = str.charAt(i);
				int j = i+1;
				while(j<n && str.charAt(j) == str.charAt(i))
					j++;
				Pair p = new Pair(current, (j-i));
				arrlist.add(p);
				i = j;
			}
			int ans = 0;
			int index = 0;
			for(Pair p: arrlist){
				// System.out.print(p.c + " " + p.count + " | ");
				ans += ((p.count+1)*p.count)/2;
				int j = index+1;
				int k = index-1;
				if(j<n && k>=0){
					Pair prev = arrlist.get(k);
					Pair next = arrlist.get(j);
					if(prev.c == next.c)
					ans += Math.min(prev.count, next.count); 
				}
				index++;
			}
			System.out.println(ans);

		}
	}
}