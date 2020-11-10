package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BinaryTree {
	
	static class Node {
		Node left, right;
		int data;
		Node(int d) {
			data = d;
			left = right = null;
		}
	}
	
	static Node root;
	
	BinaryTree() {
		root = null;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20); 
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.print("INORDER TRAVERSAL: ");
		tree.inorderTraversal(root);
		System.out.print("\nPREORDER TRAVERSAL: ");
		tree.preorderTraversal(root);
		System.out.print("\nPOSTORDER TRAVERSAL: ");
		tree.postorderTraversal(root);	
		
		System.out.print("\n\nINORDER TRAVERSAL WITHOUT RECURSION: ");
		tree.inorderWithoutRecursion(root);
		System.out.print("\nPREORDER TRAVERSAL WITHOUT RECURSION: ");
		tree.preorderWithoutRecursion(root);
		System.out.print("\nPOSTORDER TRAVERSAL WITHOUT RECURSION: ");
		tree.postorderWithoutRecursion(root);	
		
		System.out.print("\n\nLEVEL ORDER TRAVERSAL: ");
		tree.levelOrderTraversal(root);
	}
	
	void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node current = q.poll();
			System.out.print(current.data + " ");
			if(current.left!=null) {
				q.add(current.left);
			}
			if(current.right!=null) {
				q.add(current.right);
			}
		}
	}
	
	void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}
	
	void preorderTraversal(Node root) {
		if(root!=null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	void postorderTraversal(Node root) {
		if(root!=null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	void inorderWithoutRecursion(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node c = root;
		s.push(root);
		while(! s.isEmpty()) {
			while(c.left!=null) {
				c = c.left;
				s.push(c);
			}
			c = s.pop();
			System.out.print(c.data + " ");
			if(c.right!=null) {
				c = c.right;
				s.push(c);
			}
		}
		
	}
	
	void preorderWithoutRecursion(Node root) {
		Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
        	current = stack.pop();
        	System.out.print(current.data+ " ");
        	
        	if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);                
            }
        }
	}
	
	void postorderWithoutRecursion(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		while(!s1.isEmpty()) {
			Node c = s1.pop();
			s2.push(c);
			if(c.left!=null) {
				s1.push(c.left);
			}
			if(c.right!=null) {
				s1.push(c.right);
			}
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
}
