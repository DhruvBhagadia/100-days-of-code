import java.util.*;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node root;
	LinkedList(){
		this.root = null;
	}
	
	void insert(int data){
		Node new_node = new Node(data);
		Node prev = null;
		Node current = this.root;
		while(current != null){
			prev = current;
			current = current.next;
		}
		if (current == this.root) {
			root = new_node;
		}
		else{
			prev.next = new_node;
		}
	}

	void display(){
		Node current = this.root;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

	int getCount(){
		Node current = this.root;
		int count=0;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}

	void nThNodeFromTheLast(int n){
		// https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
		int itr=1;
		int count=getCount();
		Node current = this.root;
		while(current != null && itr++ != ((count-n)+1))
			current = current.next;
		if(current == null)
			return;
		else
			System.out.println(current.data);
	}

	Boolean isPalindrome(){
		int itr=0;
		Node current = this.root;
		int count = getCount();
		if(count == 0)
			return false;
		int mid = count/2;
		Stack<Integer> stack = new Stack<Integer>();
		while(itr++ != mid){
			stack.push(current.data);
			current = current.next;
		}
		if(count%2 != 0)
			current = current.next;
		while(!stack.isEmpty()){
			if(stack.pop() != current.data)
				return false;
			current = current.next;
		}
		return true;
	}

}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 1};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}
		if (ll.isPalindrome())
			System.out.println("yes");
		else
			System.out.println("no");
		//ll.display();
	}
}
