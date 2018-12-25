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

	void delete(int data){
		Node prev = null;
		Node current = this.root;
		while(current != null && current.data != data){
			prev = current;
			current = current.next;
		}
		if(current == this.root){
			this.root = current.next;
			return;
		}
		prev.next = current.next;
	}

	int getMiddle() {
		if(this.root == null)
			return -1;
		else if(this.root.next == null){
			//System.out.println(this.root.data);
			return this.root.data;
		}	
		Node slow = this.root;
		Node fast = slow.next;
		boolean even = false;
		while(fast != null){
			fast = fast.next;
			even = true;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
				even = false;
			}
		}
		if (even) {
			//System.out.println(slow.next.data);
			return slow.next.data;
		}
		//System.out.println(slow.data);
		return slow.data;
	}
	
	void removeNodesWhoseSumIsZero(){

		Node current = this.root;
		int i=0;
		while(current != null){
			int sum = 0;
			Node list = current.next;
			Stack<Integer> stack = new Stack<Integer>();
			while(true){
				if(list == null){
					//System.out.println("aaivo");
					current = current.next;
					break;
				}
				stack.push(list.data);
				sum += list.data;
				if(current.data + sum == 0){
					this.delete(current.data);
					while(!stack.isEmpty()){
						this.delete(stack.pop());
					}
					current = this.root;
					break;
				}
				else if(sum > current.data){
					sum = 0;
					while(!stack.isEmpty())
						stack.pop();
					list = list.next;
				}
				else
					list = list.next;
			}
		}
	}

	void removeDuplicates(){
		Node current = this.root;
		int i=0;
		while(current != null){
			Node list = current.next;
			while(list != null && list.data == current.data){
				list = list.next;
			}
			current.next = list;
			current = list;
		}
	}

}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {11, 11, 11, 23, 23, 44, 55, 55, 55, 55, 66, 77, 88, 88};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}

		// int ans = ll.getMiddle();
		// if (ans != -1) {
		// 	ll.delete(ans);
		// }

		//ll.removeNodesWhoseSumIsZero();

		//ll.removeDuplicates();

		ll.display();
	}
}

// void sort_asc(){
	// 	Node current = this.root;
	// 	Node prev = null;
	// 	if (current == null) {
	// 		return;
	// 	}
	// 	Node successor = this.root.next;
	// 	while(successor != null){
	// 		//System.out.println("hi");
	// 		if(current.data > successor.data){
	// 			current.next = successor.next;
	// 			successor.next = current;
	// 			if(current == this.root)
	// 				this.root = successor;
	// 			if(prev != null){
	// 				prev.next = successor;
	// 				prev = successor;
	// 			}
	// 			successor = current.next;
	// 		}
	// 		else {
	// 			current = successor;
	// 			successor = successor.next;
	// 		}
	// 	}
	// }