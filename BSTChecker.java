package interviewcake;

import interviewcake.models.BinaryTreeNode;

public class BSTChecker {

	static int MIN = Integer.MIN_VALUE;
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, null);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);

		System.out.println(isBST(fifty, MIN, MAX));
	}
	
	public static boolean isBST(BinaryTreeNode tree, int lb, int ub) {
		
		if (tree == null) return true;
		if (tree.value>=lb && tree.value<=ub) {
			return isBST(tree.left, lb, tree.value) && isBST(tree.right, tree.value, ub);
		}
		return false;
	}
	
	public class Depths{
		int min;
		int max;
		boolean isB;
	}
	
	

}
