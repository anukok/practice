package interviewcake;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import interviewcake.models.BinaryTreeNode;

public class BfsDfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, null);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);
		
		printBfs(fifty);
		System.out.println("");
		printDfs(fifty);
		System.out.println("");
		invertTree(fifty);
		printBfs(fifty);

	}
	
	public static void printBfs(BinaryTreeNode tree) {
		if (tree == null) return;
		
		Queue<BinaryTreeNode> nodeQ = new LinkedList<BinaryTreeNode> ();
		
		nodeQ.add(tree);
		
		while (!nodeQ.isEmpty()) {
			BinaryTreeNode node = nodeQ.remove();
			printNode(node);
			if (node.left != null) {
				nodeQ.add(node.left);
			}
			if (node.right != null) {
				nodeQ.add(node.right);
			}
			
		}
	}
	
	public static void printDfs(BinaryTreeNode tree) {
		
		if (tree == null) return;
		
		Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
		
		nodeStack.push(tree);
		while(!nodeStack.isEmpty()) {
			BinaryTreeNode node = nodeStack.pop();
			printNode(node);
			if (node.right !=null) {
				nodeStack.push(node.right);
			}
			if (node.left !=null) {
				nodeStack.push(node.left);
			}
		}
		
	}
	
	public static void printInorder(BinaryTreeNode node) {
		//http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	}
	
	public static void printNode(BinaryTreeNode node){
		System.out.print(" " + node.value + " ");
	}
	
    public static void invertTree(BinaryTreeNode tree) {
		if (tree == null) return;
		
		invertTree(tree.left);
		invertTree(tree.right);
		// switch left and right
		BinaryTreeNode temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		return;
		
	}

}
