package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import interviewcake.models.BinaryTreeNode;

public class FlattenTree {
//http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode three = new BinaryTreeNode( 3, null, null); 
		BinaryTreeNode four = new BinaryTreeNode( 4, null, null); 
		BinaryTreeNode six = new BinaryTreeNode( 6, null, null); 
		
		BinaryTreeNode two = new BinaryTreeNode( 2, three, four); 
		BinaryTreeNode five = new BinaryTreeNode( 5, null, six);
		
		BinaryTreeNode one = new BinaryTreeNode( 1, two, five);
		
		List<BinaryTreeNode> flatTree = flatten(one);
		
		System.out.println(flatTree);
		
		System.out.println(flattenBfs(one));
		
	}

	public static List<BinaryTreeNode> flatten(BinaryTreeNode tree) {
		List<BinaryTreeNode> result = new ArrayList<BinaryTreeNode>();
		
		if (tree == null) return result;
		
		List<BinaryTreeNode> left = null;
		List<BinaryTreeNode> right = null;
		
		if (tree.left != null) {
			left = flatten(tree.left);
		}
		
		if (tree.right != null) {
			right = flatten(tree.right);
		}
		
		// combine lists
		
		result.add(tree);
		if (left != null) {
			result.addAll(left);
			
		}
		if (right != null) {
			result.addAll(right);
			
		}
		return result;
	}
	
	public static List<BinaryTreeNode> flattenBfs(BinaryTreeNode tree) { 
		
		List<BinaryTreeNode> result = new ArrayList<BinaryTreeNode>();
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		q.add(tree);
		
		while (!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			result.add(node);
			
			if (node.left!= null) {
				q.add(node.left);
			}
			if (node.right!= null) {
				q.add(node.right);
			}
		}
		
		return result;
	}
}
