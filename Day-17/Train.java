import java.util.*;

class Train {
	static int factorial(int n) { 
        if (n == 0) 
          return 1; 
          
        return n*factorial(n-1); 
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int x = sc.nextInt();
			int n = sc.nextInt();
			sc.nextLine();
			String[] in = new String[n];
			int index = 0;
			for(int i=0; i<n; i++)
				in[i] = sc.nextLine();
			int ans=0;
			ArrayList<ArrayList<Integer>> glb_arrlist = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<9; i++){
				ArrayList<Integer> arrlist = new ArrayList<Integer>();
				glb_arrlist.add(arrlist);
			}
			int counter = 0;
			int cmp_no = 0;
			Boolean first = true;
			ArrayList<Integer> arrlist = glb_arrlist.get(0);
			for(int i=1; i <= 36; i++){
				if(counter%4 == 0 && !first){
					cmp_no++;
					arrlist = glb_arrlist.get(cmp_no);	
				}	
				arrlist.add(i);
				counter++;
				first = false;
			}
			counter = 0;
			cmp_no = 8;
			first = true;
			arrlist = glb_arrlist.get(8);
			for(int i=37; i <= 54; i++){
				if(counter%2 == 0 && !first){
					cmp_no--;
					arrlist = glb_arrlist.get(cmp_no);	
				}	
				arrlist.add(i);
				counter++;
				first = false;
			}
			int final_ans = 0;
			for(int k=0; k<n; k++){
				for (int i=0; i<9; i++) {
					ArrayList<Character> current_situation = new ArrayList<Character>();
					for(int j=0; j<6; j++){
						current_situation.add(in[k].charAt(glb_arrlist.get(i).get(j)-1));
					}
					int occurrences = Collections.frequency(current_situation, '0');
					int temp = 0;
					if(occurrences >= x){
						temp = (factorial(occurrences)/((factorial(x))*(factorial(occurrences-x))));
					}
					final_ans += temp;
				}
			}
			System.out.println(final_ans);
		}
	}
}