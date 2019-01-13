import java.util.*;

class Neighbours {
	static Queue<Integer> qi = new LinkedList<>();
	static Queue<Integer> qj = new LinkedList<>();
	static int min = 1;
	static int no = 1;
	static int[][] arr;
	static ArrayList<Integer> used = new ArrayList<Integer>();
	static ArrayList<Integer> glb_list = new ArrayList<Integer>();
	static int n, m, previous_i, previous_j;

	public static Boolean conflictWithPrevious(int term, int i, int j){
		if(!((previous_i == (i+1) && previous_j == (j+1)) || (previous_i == (i-1) && previous_j == (j-1)) 
			|| (previous_i == (i-1) && previous_j == (j+1)) || (previous_i == (i-1) && previous_j == (j-1)))){
			//System.out.println("here");
			return false;
		}
		int temp_i, temp_j, right=0, below=0, up=0, left=0;
		//right
		temp_i = previous_i;
		temp_j = previous_j+1;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			right = arr[temp_i][temp_j];
		//below
		temp_i = previous_i+1;
		temp_j = previous_j;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			below = arr[temp_i][temp_j];
			
		//left
		temp_i = previous_i;
		temp_j = previous_j-1;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			left = arr[temp_i][temp_j];
				
		//up
		temp_i = previous_i-1;
		temp_j = previous_j;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			up = arr[temp_i][temp_j];
		glb_list.add(right);
		glb_list.add(below);
		glb_list.add(left);
		glb_list.add(up);
		if(glb_list.contains(term))
			return true;
		else
			return false;
	}

	public static int getSafeValue(int term){
		int h;
		for(h=1; h<=min; h++){
			if(!glb_list.contains(h)){
				return h;
			}
		}
		return h;
	}

	public static void resolveConflict(int i, int j, int conflicting_term){
		Queue<Integer> copy_qi = new LinkedList<>(qi);
		Queue<Integer> copy_qj = new LinkedList<>(qj);
		int ti=0, tj=0, k, l;
		while(!copy_qi.isEmpty()){
			k= copy_qi.remove();
			l = copy_qj.remove();
			if(arr[k][l] == conflicting_term){
				ti = k;
				tj = l;
			}
		}
		int temp_i, temp_j, right=0, below=0, up=0, left=0;
		//right
		temp_i = i;
		temp_j = j+1;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			right = arr[temp_i][temp_j];
		//below
		temp_i = i+1;
		temp_j = j;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			below = arr[temp_i][temp_j];
			
		//left
		temp_i = i;
		temp_j = j-1;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			left = arr[temp_i][temp_j];
				
		//up
		temp_i = i-1;
		temp_j = j;
		if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
			up = arr[temp_i][temp_j];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(right);
		list.add(below);
		list.add(left);
		list.add(up);
		int h;
		//System.out.println("lad: " + list);
		for(h=1; h<=min; h++){
			if(!list.contains(h)){
				if(conflictWithPrevious(h, i, j)){
					// System.out.println("ys");
					// System.out.println("previous_i: " + previous_i);
					// System.out.println("previous_j: " + previous_j);
					h = getSafeValue(h);
				}
				arr[ti][tj] = h;
				if(h > min)
					min = h;
				break;	
			}
		}
		if(h > min){
			arr[ti][tj] = h;
			min = h;
			no = h;
			no++;
		}
		//System.out.println(h);
	}

	public static void updateGrid(int temp_i,int temp_j,int i,int j){
		//System.out.println("updateGrid");
		//System.out.println(temp_i + " " + temp_j);
		if(arr[temp_i][temp_j] == -1){
			if(!used.contains(no)){
				//System.out.println("no: "+ no);
				arr[temp_i][temp_j] = no;
				used.add(no);
				qi.add(temp_i);
				qj.add(temp_j);
				if(no > min)
					min = no;
				no++;
			}
			else{
				arr[temp_i][temp_j] = no;
				resolveConflict(i, j, no);
				qi.add(temp_i);
				qj.add(temp_j);
				no++;
			}
		}
		else {
			int k = arr[temp_i][temp_j];
			//System.out.println("k: " + k);
			if(used.contains(k)){
				resolveConflict(i, j, k);
			}
			else{
				//System.out.println("in else");
				used.add(k);
			}
		}
	}

	public static void clearUsed() {
		used.clear();
		no = 1;
	}

	public static void main(String args[]) {
		//System.out.println(i);
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				n=sc.nextInt();
				m=sc.nextInt();
				arr = new int[n][m];
				for(int i=0; i<n; i++)
					for(int j=0; j<m; j++)
						arr[i][j] = -1;
				arr[0][0] = min;
				qi.add(0);
				qj.add(0);
				int ll = 0;
				//!qi.isEmpty()
				while(!qi.isEmpty()){
					int i = qi.remove();
					int j = qj.remove();
					int temp_i, temp_j;
					//right
					temp_i = i;
					temp_j = j+1;
					if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m)){
						//System.out.println("right");
						updateGrid(temp_i, temp_j, i, j);
					}
					//below
					temp_i = i+1;
					temp_j = j;
					if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m)){
						//System.out.println("below");
						updateGrid(temp_i, temp_j, i, j);
					}
						
					//left
					temp_i = i;
					temp_j = j-1;
					if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m)){
						//System.out.println("left");
						updateGrid(temp_i, temp_j, i, j);
					}
						
					//up
					temp_i = i-1;
					temp_j = j;
					if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m)){
						//System.out.println("up");
						updateGrid(temp_i, temp_j, i, j);
					}
					clearUsed();
					previous_i = i;
					previous_j = j;
					// System.out.println(min);
					// for(int p=0; p<n; p++)
					// 	System.out.println(Arrays.toString(arr[p]));
					System.out.println("qi: " + qi);
					System.out.println("qj: " + qj);
					System.out.println("-----------------------");
					for(int h=0; h<n; h++){
						for (int b=0; b<m; b++) {
							System.out.print(arr[h][b] + " ");
						}	
						System.out.println();
					}
				}
				System.out.println(min);
				for(int i=0; i<n; i++){
					for (int j=0; j<m; j++) {
						System.out.print(arr[i][j] + " ");
					}	
					System.out.println();
				}	
			}
		}
	}
}