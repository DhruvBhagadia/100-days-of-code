import java.util.*;
import java.lang.*;
import java.io.*;

class BubbleUsingStack {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for(int j=arr.length-1; j>=0; j--){
			stack1.push(arr[j]);
			for(int i=j-1; i>=0; i--){
				if(arr[i] > stack1.peek()){
					stack2.push(stack1.pop());
					stack1.push(arr[i]);
				}
				else
					stack2.push(arr[i]);
			}
			int i=0;
			while(!stack2.isEmpty())
				arr[i++] = stack2.pop();
			arr[i] = stack1.pop();
		}
		System.out.println(Arrays.toString(arr));
	}
}