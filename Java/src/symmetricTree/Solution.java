/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	/* this is the recursive version of the solution. */
    public boolean isSymmetric(TreeNode root) {
       if (root == null) {
		   return true;
	   } 

	   return helper(root.left, root.right);
	}

	helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		
		else if (left == null || right == null
				|| left.val != right.val) {
			return false;
		}

		return (helper(left.left, right.right) && 
				helper(left.right, right.left));
	}

	/* This is the iterative version of the solution. */
	public boolean isSymmetricIter(TreeNode root) {
		/* the condition where the root does not exist. */
		if (root == null) {
			return true;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;
		Deque<TreeNode> level1 = new LinkedList<TreeNode>();
		Deque<TreeNode> level2 = new LinkedList<TreeNode>();

		level1.addFirst(root.left);
		level1.addLast(root.right);
		
		while(!level1.isEmpty()) {	
			while (!level1.isEmpty()) {
				
				left = level1.pollFirst();
				right = level1.pollLast();
				if (left == null && right == null) {
					continue;
				} else if (left == null || right == null
						|| left.val != right.val) {
					return false;
				} else if (left.val == right.val) {
					level2.addFirst(left.left);
					level2.addLast(right.right);
					level2.addFirst(left.right);
					level2.addLast(right.left);
				}

			}

			Deque<TreeNode> temp = level1;
			level1 = level2;
			level2 = temp;
		}

		return true;
	}
			

}
