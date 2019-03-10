import java.util.*;

class Pair{
	Integer inp;
	Integer occ;
	Pair(Integer inp, Integer occ){
		this.inp = inp;
		this.occ = occ;
	}
}

class New {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				// ArrayList<Integer> keys = new ArrayList<Integer>();
				// ArrayList<Integer> values = new ArrayList<Integer>();
				ArrayList<Pair> arrlist = new ArrayList<Pair>();
				for(int ii=0; ii<n; ii++){
					String temp = sc.nextLine();
					int k = 0;
					for(int j=0; j<temp.length(); j++)
						k |= (1<<(temp.charAt(j)-'a'));
					Boolean flag = false;
					// System.out.println(temp + "-->" + k);
					for(int i=0; i<arrlist.size(); i++){
						if(arrlist.get(i).inp == k){
							int occ = arrlist.get(i).occ;
							Pair p = new Pair(arrlist.get(i).inp, occ+1);
							arrlist.set(i, p);
							flag = true;
						}
					}
					if(!flag){
						Pair p = new Pair(k, 1);
						arrlist.add(p);
					}
				}
				int correct = (1<<('a'-'a')) | (1<<('e'-'a')) | (1<<('i'-'a'))
					 | (1<<('o'-'a')) | (1<<('u'-'a'));
				int ans = 0;
				// System.out.println(correct);
				// for (int i=0; i<arrlist.size(); i++) {
				// 	System.out.println(arrlist.get(i).inp + " " + arrlist.get(i).occ);
				// }
				// System.out.println(Arrays.toString(keys.toArray()));
				// System.out.println(Arrays.toString(values.toArray()));
				for(int i=0; i<arrlist.size()-1; i++){
					for(int j=i+1; j<arrlist.size(); j++){
						int first = arrlist.get(i).inp;
						int second = arrlist.get(j).inp;
						int f_occ = arrlist.get(i).occ;
						int s_occ = arrlist.get(j).occ;
						if((first | second) == correct){
							// System.out.println(keys.get(i) + " " + keys.get(j));
							ans += (f_occ*s_occ);
							// System.out.println(ans);
						}
					}
				}
				for(int i=0; i<arrlist.size(); i++){
					if(arrlist.get(i).inp == correct){
						int val = arrlist.get(i).occ;
						ans += (val*(val-1)/2);
					}
				}
				System.out.println(ans);
			}
		}
	// 	for(int i=0; i<31; i++)
	// 		System.out.println("aeu");
	}
}

/*
25+13+31=69
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
aaaaaaeeeeeeeeooooooou
i
i
i
i
i
i
i
i
i
i
i
i
i
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu
aeu

*/