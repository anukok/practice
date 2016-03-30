package leetcode;

import java.util.Stack;

import interviewcake.models.BinaryTreeNode;

public class BSTIterator {

	//http://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Iterator {
		
		Stack<BinaryTreeNode> stack;

		public Iterator(BinaryTreeNode tree){
			while(tree!=null) {
				stack.push(tree);
				tree = tree.left;
			}
		}

		public int next() {
			if (!stack.isEmpty()) {
				BinaryTreeNode node = stack.pop();
				if (node.right != null) {
					node = node.right;
					while(node !=null) {
						stack.push(node);
						node = node.left;
					}
				}
			}
			return 0;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}

}


