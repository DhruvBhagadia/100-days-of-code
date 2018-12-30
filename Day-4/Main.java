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

}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 3, 5, 6, 7, 10};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}
		ll.nThNodeFromTheLast(6);
		//ll.display();
	}
}
