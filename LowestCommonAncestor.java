package interviewcake;

import java.util.ArrayList;
import java.util.List;

import interviewcake.models.BinaryTreeNode;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, null);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);
		
		System.out.println(lca(fifty, eighty, thirty).value);
		System.out.println(lcaInBST(fifty, eighty, thirty).value);

	}
	
	public static BinaryTreeNode lcaInBST(BinaryTreeNode tree, BinaryTreeNode node1, BinaryTreeNode node2) {
		// TODO
		//http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-search-tree-java/
		
		BinaryTreeNode first = node1.value <= node2.value? node1 : node2;
		BinaryTreeNode second = node1.value > node2.value? node1 : node2;
		
		if (tree.value >= first.value && tree.value <= second.value) {
			return tree;
		} else if (first.value > tree.value) {
			return lcaInBST(tree.right, first, second);
		} else if (second.value < tree.value) {
			return lcaInBST(tree.left, first, second );
		}
		
		return null;
	}
	
	public static BinaryTreeNode lca2(BinaryTreeNode tree, BinaryTreeNode node1, BinaryTreeNode node2) {
		
		if (tree == null) {
			return null;
		}
		if (tree == node1 || tree == node2) {
			return tree;
		}
		BinaryTreeNode left = lca2(tree.left, node1, node2);
				
		BinaryTreeNode right = lca2(tree.right, node1, node2);
		
		if (left != null && right != null) {
			return tree;
		}
		if (left != null) return left;
		
		if (right != null) return right;
		
		return null;
	}
	
	public static BinaryTreeNode lca(BinaryTreeNode tree, BinaryTreeNode node1, BinaryTreeNode node2) {
		
		List<BinaryTreeNode> path1 = findPath(tree, node1);
		List<BinaryTreeNode> path2 = findPath(tree, node2);
		int i=0; int len = Math.min(path1.size(), path2.size());
		for (i=0; i<len; i++) {
			if (path1.get(i) != path2.get(i)) {
				break;
			}
		}
		return path1.get(i-1);
	}
	
	public static List<BinaryTreeNode> findPath(BinaryTreeNode tree, BinaryTreeNode node) {
		List<BinaryTreeNode> path =  new ArrayList<BinaryTreeNode>();
		path.add(tree);
		
		if (tree == node) {
			return path;
		}
		
		if (tree.left!=null) {
			List<BinaryTreeNode> subPath = findPath(tree.left, node);
			if (subPath != null) {
				path.addAll(subPath);
				return path;
			}
		}
		
		if (tree.right!=null) {
			List<BinaryTreeNode> subPath = findPath(tree.right, node);
			if (subPath != null) {
				path.addAll(subPath);
				return path;
			}
		}
		
		return null;
	}

}
