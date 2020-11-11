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
	
	public boolean delete(int key) {
		if(find(root,key)) {
			root = deleteHelper(root, key);
			return true;
		}
		return false;
	}
	
	private Node deleteHelper(Node root, int key) {
		if(root==null) return null;
		
		if(key == root.data) {
			// CASE 1: LEAF NODE
			if(root.left == null && root.right==null) {
				return null;
			}
			// CASE 2: LEFT SUBTREE NULL
			else if(root.left == null) {
				return root.right;
			}
			// CASE 3: RIGHT SUBTREE NULL
			else if(root.right == null) {
				return root.left;
			} 
			// CASE 4: LEFT AND RIGHT SUBTREE NOT NULL
			int minVal = findMin(root.right);
			System.out.println("\n"+minVal +"\n");
			root.data = minVal;
			root.right = deleteHelper(root.right, minVal);
			return root;
		}
		
		else if(key < root.data) {
			root.left = deleteHelper(root.left, key);
			return root;
		}
		
		root.right = deleteHelper(root.right, key);
		return root;
				
	}
	
	private int findMin(Node root) {
		while(root.left!=null) {
			root = root.left;
		}
		return root.data;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(7);
        bst.recursiveInsert(5);
        bst.insert(20);
        bst.recursiveInsert(4);
        bst.insert(18);
        bst.recursiveInsert(25);
        bst.insert(2);
        bst.insert(11);
        bst.insert(19);
        bst.insert(33);
        bst.insert(1);
        bst.insert(3);
        bst.insert(14);
        bst.insert(28);
        bst.insert(12);
        bst.insert(15);
        bst.recursiveInsert(31);
        
        System.out.println(bst.delete(7) == false ? "Element not in the Tree\n" : "Deleted\n");
        System.out.println(bst.delete(9) == false ? "Element not in the Tree\n" : "Deleted\n");

        
        System.out.println("INORDER TRAVERSAL: ");
        bst.inorderTraversal(root);
        System.out.println();
        System.out.println(bst.find(root, 8) == false ? "Not found" : "Found");
        System.out.println(bst.find(root, 10) == false ? "Not found" : "Found");
	}

}

