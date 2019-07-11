//Reference: https://www.youtube.com/watch?v=HqPJF2L5h9U

import java.util.*;

class MaxHeap{
	static ArrayList<Integer> heap;
	static int size;

	public static void adjustTreeAfterInsertion(int index){
		//Bottom up (leaf to root)
		while(index > 0){
			int parent = (index-1)/2;
			if(heap.get(index) > heap.get(parent)){
				Collections.swap(heap, index, parent);
				index = parent;
			}
			else
				break;
		}
	}

	public static int delete(){
		if(size == 0)
			return -1;
		int max_ele = heap.get(0);
		heap.set(0, heap.get(size-1));
		size--;
		int to_be_compared = 0;
		int swapping_index = 0;
		int index = 0;
		while(index < size){
			int left = (2*index+1);
			int right = (2*index+2);
			if(left >= size)
				break;
			if(right >= size)
				swapping_index = left;
			else if(heap.get(right) > heap.get(left))
				swapping_index = right;
			else
				swapping_index = left;
			if(heap.get(index) < heap.get(swapping_index)){
				Collections.swap(heap, index, swapping_index);
				index = swapping_index;
			}
			else
				break;
		}
		return max_ele;
	}

	public static void heapSort(){
		size = heap.size();
		for(int i=heap.size()-1; i>=0; i--)
			heap.set(i, delete());
	}

	public static void heapify(int i){
		int left = (2*i+1);
		int right = (2*i+2);
		int swapping_index = 0;
		if(left >= heap.size())
			return;
		if(right >= heap.size())
			swapping_index = left;
		else if(heap.get(right) > heap.get(left))
			swapping_index = right;
		else
			swapping_index = left;
		if(heap.get(i) < heap.get(swapping_index)){
			Collections.swap(heap, i, swapping_index);
			heapify(swapping_index);
		}
	}

	public static void main(String args[]){
		heap = new ArrayList<Integer>();
		int[] ele = {34, 12, 56, 30, 89};
		for(int i=0; i<ele.length; i++){
			heap.add(ele[i]);
			adjustTreeAfterInsertion(heap.size()-1); 
		}
		System.out.println("Heap created: " + Arrays.toString(heap.toArray()));
		heapSort();
		System.out.println("After heap sort: " + Arrays.toString(heap.toArray()));

		//To demonstrate heapify
		heap = new ArrayList<Integer>(Arrays.asList(10, 20, 15, 12, 40, 25, 18));
		for(int i=heap.size()-1; i>=0; i--)
			heapify(i);
		System.out.println("After heapify: " + Arrays.toString(heap.toArray()));
	}
}