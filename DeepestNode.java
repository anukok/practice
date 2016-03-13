package interviewcake;

import java.util.Map;

import interviewcake.models.BinaryTreeNode;

public class DeepestNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DeepestNode driver = new DeepestNode();
		
	}
	public class NodeDepth {
		public BinaryTreeNode node;
		public int depth;
		
		NodeDepth(BinaryTreeNode node, int depth){
			this.node = node;
			this.depth = depth;
		}
	}
	public NodeDepth deepestNode(BinaryTreeNode tree) {
		//base case
		if (tree == null) return null;
		if (tree.left == null && tree.right == null) {
			return new NodeDepth(tree, new Integer(0));
		}
		
		NodeDepth left = deepestNode(tree.left);
		NodeDepth right = deepestNode(tree.right);
		
		return (left.depth >= right.depth) ? new NodeDepth(left.node, left.depth +1) :
			 new NodeDepth(right.node, right.depth +1);
		
	}

}
