import java.util.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data) {
    	this.data = data;
    	left = null;
    	right = null;
    }
}

class Tree {
    Node root = null;

    void insert(int data){
    	Node node = new Node(data);
    	if(root == null)
    		root = node;
    	else{
    		Node ptr = root;
	    	while(true){
	    		if(ptr.data > node.data){
		    		if(ptr.left == null){
		    			ptr.left = node;
		    			break;
		    		}
		    		else
		    			ptr = ptr.left;
		    	}
		    	else{
		    		if(ptr.right == null){
		    			ptr.right = node;
		    			break;
		    		}
		    		else
		    			ptr = ptr.right;
		    	}
	    	}
    	}
    }

    void inorder(Node ptr){
    	if(ptr == null)
    		return;
    	inorder(ptr.left);
    	System.out.print(ptr.data + " ");
    	inorder(ptr.right);
    }

    void levelorder(){
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	Queue<Node> q2 = new LinkedList<>();
    	while(true){
    		while(!q.isEmpty()){
	    		Node ptr = q.remove();
	    		System.out.print(ptr.data + " ");
	    		if(ptr.left != null)
		    		q2.add(ptr.left);
		    	if(ptr.right != null)
		    		q2.add(ptr.right);
	    	}
	    	if(q2.isEmpty())
	    		break;
	    	q = q2;
	    	q2 = new LinkedList<>();
	    	System.out.println();
    	}
    }

    void delete(int val){
    	Node ptr = root;
    	Node parent = null;
    	while(ptr != null && ptr.data != val){
    		parent = ptr;
    		if(val > ptr.data)
    			ptr = ptr.right;
    		else
    			ptr = ptr.left;
    	}
    	if(ptr.left == null && ptr.right == null){
    		if(parent.right == ptr)
    			parent.right = null;
    		else
    			parent.left = null;
    	}
    	else if(ptr.left == null || ptr.right == null){
    		if(ptr.left == null){
    			if(parent.right == ptr)
	    			parent.right = ptr.right;
	    		else
	    			parent.left = ptr.right;
    		}
    		else{
    			if(parent.right == ptr)
	    			parent.right = ptr.left;
	    		else
	    			parent.left = ptr.left;
    		}
    	}
    	else{
    		Node temp = ptr.right;
    		while(!(temp.right == null && temp.left == null)){
    			parent = temp;
    			temp = temp.left;
    		}
    		ptr.data = temp.data;
    		if(parent.right == temp)
    			parent.right = null;
    		else
    			parent.left = null;
    	}
    }
}

class Main{
	public static void main(String args[]){
		int[] arr = {5, 2, 12, -4, 3, 21, 19, 25};
		Tree tree = new Tree();
		for(int i=0; i<arr.length; i++){
			tree.insert(arr[i]);
		}
		tree.delete(12);
		// tree.inorder(tree.root);
		System.out.println();
		tree.levelorder();
		System.out.println();	
	}
}