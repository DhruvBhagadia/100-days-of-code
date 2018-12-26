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

	int getCount(){
		Node current = this.root;
		int count=0;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
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

	void reverseContinuouslyForAGivenRange(int k) {
		//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
		int count = getCount();
		boolean proper = count%k==0 ? true : false;
		int iterations = count/k;
		Node current = this.root;
		Node prev = null;
		while(iterations-- != 0){
			reverse(current, k);
			int temp=k;
			while(current != null && temp-- != 0){
				prev = current;
				current = current.next;
			}
		}
		if(!proper){
			int count2 = 0;
			Node temp = current;
			while(temp != null){
				count2++;
				temp = temp.next;
			}
			reverse(current, count2);
		}
	}

	void reverse(Node start, int k) {

		Stack<Integer> stack = new Stack<Integer>();
		Node current = start;
		int count = 0;
		while(count++ != k){
			stack.push(current.data);
			current = current.next;
		}
		current = start;
		while(count-- != 1){
			current.data = stack.pop();
			current = current.next;
		}
	}

	void rotate(int k){
		//https://www.geeksforgeeks.org/rotate-a-linked-list/
		Node current = this.root;
		if (current == null || current.next == null || k <= 0)
			return;
		Node prev = null;
		Node last = this.root;
		int count = 1;
		while(current != null && count++ != k)
			current = current.next;
		if (current == null) {
			return;
		}
		while(last != null){
			prev = last;
			last = last.next;
		}
		Node temp = current.next;
		current.next = null;
		prev.next = this.root;
		this.root = temp;
	}



}

class Main {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		int[] arr = {1, 2, 3, 4, 5 ,6};
		for (int i=0; i<arr.length; i++) {
			ll.insert(arr[i]);
		}

		ll.reverseContinuouslyForAGivenRange(5);

		ll.display();
	}
}
