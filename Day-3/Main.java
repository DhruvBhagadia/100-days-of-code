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

	void createLoop(){
		//dummy function to create a loop to test hasLoop()
		Node current = this.root;
		Node prev = null;
		Node successor = current.next;
		while(successor != null){
			prev = current;
			current = successor;
			successor = current.next;
		}
		Node new_node = new Node(100);
		new_node.next = prev;
		current.next = new_node;
	}

	Boolean hasLoop(){
		//Check if any node present to next of a particular node is already visited or not
		List list = new ArrayList();
		Node current = this.root;
		list.add(current);
		while(current != null && list.indexOf(current.next) == -1){
			current = current.next;
			list.add(current);
		}
		if (current != null && list.indexOf(current.next) != -1) {
			return true;
		}
		return false;
	}
}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 3};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}
		ll.createLoop();
		if(ll.hasLoop())
			System.out.println("true");
		else
			System.out.println("false");
		//ll.display();
	}
}
