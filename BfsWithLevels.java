package interviewcake;

import interviewcake.models.BinaryTreeNode;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BfsWithLevels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode twenty = new BinaryTreeNode(20, null, null);
		BinaryTreeNode sixty = new BinaryTreeNode(60, null, null);
		BinaryTreeNode seventy = new BinaryTreeNode(70, null, null);
		BinaryTreeNode ninty = new BinaryTreeNode(90, null, null);
		
		BinaryTreeNode thirty = new BinaryTreeNode(30, twenty, sixty);
		BinaryTreeNode eighty = new BinaryTreeNode(80, seventy, ninty);
		
		BinaryTreeNode fifty = new BinaryTreeNode(50, thirty, eighty);
		
		System.out.println(bfsLevels(fifty));
		
	}
	
	public static List<List<BinaryTreeNode>> bfsLevels (BinaryTreeNode tree) {
		if (tree == null) return null;
		
		List<List<BinaryTreeNode>> nodes = new ArrayList<List<BinaryTreeNode>>();
		
		Queue<BinaryTreeNode> currLevel = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> nextLevel = new LinkedList<BinaryTreeNode>();
		
		currLevel.add(tree);
		
		List<BinaryTreeNode> level = new ArrayList<BinaryTreeNode>();
		
		while (!currLevel.isEmpty() || !nextLevel.isEmpty()) {
			
			if (currLevel.isEmpty() && !nextLevel.isEmpty()) {
				// reached end of one level
				nodes.add(level);
				//reset level
				level = new ArrayList<BinaryTreeNode>();
				currLevel = nextLevel;
				nextLevel = new LinkedList<BinaryTreeNode>();
			}
			
			BinaryTreeNode node = currLevel.poll();
			level.add(node);
			
			if (node.left != null) {
				nextLevel.add(node.left);
			}
			if (node.right != null) {
				nextLevel.add(node.right);
			}
		}
		nodes.add(level);
				
		return nodes;
	}

}
