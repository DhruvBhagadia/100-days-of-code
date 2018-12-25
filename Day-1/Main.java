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

	int getNo(int count){
		int product = 1;
		while(count-- != 0)
			product = product*10;
		return product;
	}

	void add1ToList() {

		/* https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
			LOGIC:
			1. Get the sum of all digits present in LinkedList || Suppose linkedlist is 1->9->9->9
				then the sum will be 1999
			2. Add 1 to sum
			3. To get the MSB sum/(10^(count-1)) || eg. 2000/(10^(4-1)) = 2000/(10^3) = 2000/1000 = 2
			4. Change elements in the linkedList to the answer that we get 
		*/

		int sum=0;
		int count=0;
		Node current = this.root;
		while(current != null){
			sum = sum*10 + current.data;
			current = current.next;
			count++;
		}
		int number_of_digits = count;
		sum += 1;
		count--; 
		current = this.root;
		while(number_of_digits-- != 0){
			int ans = getNo(count);
			count--;
			int digit = sum/ans;
			current.data = digit;
			current = current.next;
			sum = sum-(digit*ans);
		}
	}

}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}

		// int ans = ll.getMiddle();
		// if (ans != -1) {
		// 	ll.delete(ans);
		// }

		//ll.removeNodesWhoseSumIsZero();
		//ll.removeDuplicates();
		ll.add1ToList();

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