import java.util.*;

class PermutationCycle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		sc.nextLine();
		Boolean[] visited = new Boolean[length+1];
		int[] arr = new int[length+1]; 
		String inp = sc.nextLine();
		String[] inps = inp.split(" ");
		for (int i=1; i<=length; i++) {
			arr[i] = Integer.parseInt(inps[i-1]);
			visited[i] = false;
		}
		arr[0] = -1;
		visited[0] = false;
		int i=0;
		int count=0;
		ArrayList<StringBuilder> arrlist = new ArrayList<StringBuilder>();
		while(true){
			Queue<Integer> q = new LinkedList<>();
			int var=1;
			int temp;
			int j;
			for (j=1; j<=length; j++) {
				if(!visited[j]){
					var = j;
					break;
				}
			}
			temp = var;
			if(j > length)
				break;
			while(!visited[var]){
				q.add(var);
				visited[var] = true;
				var = arr[var];
			}
			q.add(temp);
			StringBuilder str = new StringBuilder();
			while(!q.isEmpty()){
				str = str.append(q.remove() + " ");
			}
			arrlist.add(str);
			count++;
		}
		System.out.println(count);
		for (StringBuilder str : arrlist) { 		      
		   System.out.println(str); 		
      	}
	}
}