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

	void reverse(){
		//Solving on paper can easily help understand logic
		if(this.root.next == null)
			return;
		Node prev = this.root;
		Node current = prev.next;
		Node successor = current.next;
		prev.next = null;
		while(current != null){
			current.next = prev;
			prev = current;
			current = successor;
			if (current != null) 
				successor = current.next;
		}
		this.root = prev;
	}
}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 3};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}
		ll.reverse();
		ll.display();
	}
}
