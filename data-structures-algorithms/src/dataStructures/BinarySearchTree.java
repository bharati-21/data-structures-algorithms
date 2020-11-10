package dataStructures;

public class BinarySearchTree {
	
	static class Node {
		Node left, right;
		int data;
		Node(int d) {
			data = d;
			left = right = null;
		}
	}
	
	static Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	public void recursiveInsert(int key) {
		root = recursiveInsertHelper(key, root);		
	}
	
	private Node recursiveInsertHelper(int key, Node root) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(key <= root.data) {
			root.left = recursiveInsertHelper(key, root.left);
		}
		else {
			root.right = recursiveInsertHelper(key, root.right);
		}
		return root;
	}
	
	public boolean find(Node root, int key) {
		if(root == null) {
			return false;
		}
		if(key < root.data) {
			return find(root.left, key);
		}
		else if(key > root.data) {
			return find(root.right, key);
		}
		return true;
	}
	
	public void insert(int key) {
		Node node = new Node(key);
		if(root == null) {
			root = node;
			return;
		}
		Node parent = null, current = root;
		while(current!=null) {
			parent = current;
			if(key <= current.data) {
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		if(key <= parent.data) {
			parent.left = node;
		}
		else {
			parent.right = node;
		}
	}
	
	public void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
        bst.recursiveInsert(-5);
        bst.insert(-8);
        bst.recursiveInsert(16);
        bst.insert(20);
        bst.recursiveInsert(25);
        bst.insert(7);
        
        System.out.println("INORDER TRAVERSAL: ");
        bst.inorderTraversal(root);
        System.out.println();
        System.out.println(bst.find(root, 65) == false ? "Not found" : "Found");
        System.out.println(bst.find(root, 80) == false ? "Not found" : "Found");
	}

}

