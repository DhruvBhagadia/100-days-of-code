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

	void mergeTwoLLAtAlternatePositions(Node root1, int count1, Node root2, int count2){
		//https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/

		Node current1 = root1;
		Node current2 = root2;
		int itr = 0;
		while(current1 != null && current2 != null){
			if(itr++%2 == 0){
				this.insert(current1.data);
				current1 = current1.next;
			}
			else{
				this.insert(current2.data);
				current2 = current2.next;
			}
		}
		Node last = this.root;
		while(last.next != null)
			last = last.next;
		if(current1 == null)
			last.next = current2;
		else if(current2 == null)
			last.next = current1;
	}

}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 3, 4};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}
		LinkedList ll2 = new LinkedList();
		int[] arr2 = {5, 6, 8, 9, 10, 11, 12};
		for (int i=0; i<arr2.length; i++) {
			ll2.insert(arr2[i]);
		}
		LinkedList ll3 = new LinkedList();
		ll3.mergeTwoLLAtAlternatePositions(ll.root, ll.getCount(), ll2.root, ll2.getCount());
		ll3.display();
	}
}
