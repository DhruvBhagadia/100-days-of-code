import java.util.*;

class Inversions{
	static long mergeSort(int arr[], int array_size) { 
		int temp[] = new int[array_size]; 
		return enhanchedMergeSort(arr, temp, 0, array_size - 1); 
	} 

	public static long getMergeInversions(int[] arr, int[] temp, int left, int mid, int right){ 
		int i, j, k; 
		long inv_count = 0; 

		i = left;
		j = mid;
		k = left; 
		while ((i <= mid - 1) && (j <= right)) { 
			if (arr[i] <= arr[j]) { 
				temp[k++] = arr[i++]; 
			} 
			else { 
				temp[k++] = arr[j++]; 
				inv_count = inv_count + (mid - i); 
			} 
		} 
		while (i <= mid - 1) 
			temp[k++] = arr[i++]; 
		while (j <= right) 
			temp[k++] = arr[j++]; 
		for (i = left; i <= right; i++) 
			arr[i] = temp[i]; 

		return inv_count; 
	}

	public static long enhanchedMergeSort(int[] arr, int[] temp, int left, int right){ 
		int mid;
		long right_part = 0;
		long left_part = 0;
		long merge_part = 0; 
		if (right > left) {
			mid = (right + left) / 2; 
			left_part = enhanchedMergeSort(arr, temp, left, mid); 
			right_part = enhanchedMergeSort(arr, temp, mid + 1, right); 
			merge_part = getMergeInversions(arr, temp, left, mid + 1, right); 
		} 
		return (left_part+right_part+merge_part); 
	}

	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = sc.nextInt();
				sc.nextLine();
				int[] arr = new int[n];
				for(int i=0; i<n; i++)
					arr[i] = sc.nextInt();
				long count = mergeSort(arr, arr.length);
				System.out.println(count);
			}
		}
	}
}

