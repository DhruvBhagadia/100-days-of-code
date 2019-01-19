import java.util.*;

class neighbours {

	static Queue<Integer> qi = new LinkedList<>();
	static Queue<Integer> qj = new LinkedList<>();
	static int min = 1;
	static int[][] arr;
	static int n, m;
	static ArrayList<Integer> neighbouring_elements_values = new ArrayList<Integer>();
	static ArrayList<Integer> index_i_of_neighbouring_element = new ArrayList<Integer>();
	static ArrayList<Integer> index_j_of_neighbouring_element = new ArrayList<Integer>();

	public static int getIndex(int value){
			for(int i = 0; i< neighbouring_elements_values.size();i++) {
		        if (neighbouring_elements_values.get(i).equals(value)) {
		            return i;
		        }
		    }
		    return -1;
	}

	public static void adjustGrid(){
		int index=0;
		int n_index=0;
		ArrayList<Integer> filling_list = new ArrayList<Integer>();
		for(int k=1; k<=min; k++)
			filling_list.add(k);
		System.out.println(filling_list);
		while(n_index != 4){
			if(neighbouring_elements_values.get(n_index) != 99){
				int value;
				if(neighbouring_elements_values.contains(value) && index < filling_list.size()){
					index++;
					if(index >= filling_list.size()){
						min++;
						value = min;
					}
					else
						value = filling_list.get(index);
				}
				else {
					int i = index_i_of_neighbouring_element.get(n_index);
					int j = index_j_of_neighbouring_element.get(n_index);
					arr[i][j] = value;
					qi.add(i);
					qj.add(j);
				}
			}
			n_index++;
		}
		System.out.println("qi: " + qi);
		System.out.println("gj: " + qj);
	}

	public static void main (String args[]){
		n=3;
		m=3;
		arr = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				arr[i][j] = -1;
		arr[0][0] = min;
		qi.add(0);
		qj.add(0);
		int ll=0;
		//!qi.isEmpty()
		while(ll++ != 1){
			int i = qi.remove();
			int j = qj.remove();
			int temp_i, temp_j, right, below, left, up;
			//right
			temp_i = i;
			temp_j = j+1;
			if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
				right = arr[temp_i][temp_j];
			else
				right = 99;
			neighbouring_elements_values.add(right);
			index_i_of_neighbouring_element.add(temp_i);
			index_j_of_neighbouring_element.add(temp_j);
			//below
			temp_i = i+1;
			temp_j = j;
			if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
				below = arr[temp_i][temp_j];
			else
				below = 99;	
			neighbouring_elements_values.add(below);
			index_i_of_neighbouring_element.add(temp_i);
			index_j_of_neighbouring_element.add(temp_j);
			//left
			temp_i = i;
			temp_j = j-1;
			if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
				left = arr[temp_i][temp_j];
			else
				left = 99;
			neighbouring_elements_values.add(left);
			index_i_of_neighbouring_element.add(temp_i);
			index_j_of_neighbouring_element.add(temp_j);
			//up
			temp_i = i-1;
			temp_j = j;
			if((temp_i >= 0 && temp_i<n) && (temp_j >= 0 && temp_j<m))
				up = arr[temp_i][temp_j];
			else
				up = 99;
			neighbouring_elements_values.add(up);
			index_i_of_neighbouring_element.add(temp_i);
			index_j_of_neighbouring_element.add(temp_j);
			System.out.println(neighbouring_elements_values);
			System.out.println(index_i_of_neighbouring_element);
			System.out.println(index_j_of_neighbouring_element);
			adjustGrid();
		}
	}
}
