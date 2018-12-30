class Node{
	Node prev;
	int data;
	Node next;

	Node(int data){
		this.prev = null;
		this.data = data;
		this.next = null;
	}
}

class DoubleLinkedList {
	Node root;

	DoubleLinkedList() {
		this.root = null;
	}

	void insert(int data){
		//System.out.println("in");
		Node new_node = new Node(data);
		Node current = this.root;
		Node prev = null;
		while (current != null) {
			prev = current;
			//System.out.println("in2");
			current = current.next;
		}
		if (current == this.root) {
			this.root = new_node;
		}
		else{
			prev.next = new_node;
			new_node.prev = prev	;
		}
	}

	void display() {
		Node current = this.root;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

	void displayReverse() {
		Node current = this.root;
		while(current.next != null){
			current = current.next;
		}
		Node start = current;
		while(current != null){
			System.out.println(current.data);
			current = current.prev;
		}
	}

}

class DoublyMain {
	public static void main(String args[]) {
		DoubleLinkedList dll = new DoubleLinkedList();
		int[] arr = {1, 2, 3, 4};
		for (int i=0; i<arr.length; i++) {
			dll.insert(arr[i]);
		}
		dll.displayReverse();
	}
}