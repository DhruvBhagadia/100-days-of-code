import java.util.*;
import java.lang.*;
import java.io.*;

class QueueUsingStack {
	static Stack<Integer> temp_stack;
	static Stack<Integer> final_stack;

	public static void push(int element){
		if(!final_stack.isEmpty())
			while(!final_stack.isEmpty())
				temp_stack.push(final_stack.pop());
		temp_stack.push(element);
	}

	public static void display(){
		if(!temp_stack.isEmpty())
			while(!temp_stack.isEmpty())
				final_stack.push(temp_stack.pop());
		System.out.println(final_stack);
	}

	public static int pop(){
		if(!temp_stack.isEmpty())
			while(!temp_stack.isEmpty())
				final_stack.push(temp_stack.pop());
		return final_stack.pop();	
	}

	public static int peek(){
		if(!temp_stack.isEmpty())
			while(!temp_stack.isEmpty())
				final_stack.push(temp_stack.pop());
		return final_stack.peek();		
	}

	public static Boolean isEmpty(){
		return final_stack.isEmpty();		
	}

	public static void main(String[] args) {
		temp_stack = new Stack<Integer>();
		final_stack = new Stack<Integer>();
		int[] arr = {10, 5, 3, 2};
		for (int i=0; i<arr.length; i++) 
			push(arr[i]);
		System.out.println("After pushing 4 elements");
		display();
		for (int i=0; i<2; i++) 
			System.out.println(pop());
		System.out.println("After poping 2 elements");
		display();
		int[] arr2 = {15, 20};
		for (int i=0; i<arr2.length; i++) 
			push(arr2[i]);
		System.out.println(peek());
		System.out.println("Again pushing 2 elements");
		display();
		System.out.println(isEmpty());
	}
}