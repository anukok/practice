package leetcode;

import interviewcake.models.BinaryTreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, null);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);
		
		invertTree(fifty);

	}
	
	public static void invertTree(BinaryTreeNode tree) {
		
		// check BfsDfs class
	}

}
