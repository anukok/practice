package leetcode;

import interviewcake.models.BinaryTreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/
		// depth of subtrees dont differ by more than 1 , at every node
		
		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		
		BinaryTreeNode onetwenty = new BinaryTreeNode(120, null, null);
		BinaryTreeNode hundred = new BinaryTreeNode(100, null, onetwenty);
		
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, hundred);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);
		
		System.out.println(getHeightIfBalanced(fifty));

	}
	
	public static boolean isBalanced(BinaryTreeNode tree) {
		return (getHeightIfBalanced(tree) >=0);
	}
	
	// returns height of balanced tree, returns -1 if not balanced
	public static int getHeightIfBalanced (BinaryTreeNode tree) {
		
		if (tree == null) return 0;
		
		int left = getHeightIfBalanced(tree.left); // height of left sub tree
		
		int right = getHeightIfBalanced(tree.right); // height of right sub tree
		
		if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
			return -1;
		}
				
		return Math.max(left, right)+1; 
	}

}
