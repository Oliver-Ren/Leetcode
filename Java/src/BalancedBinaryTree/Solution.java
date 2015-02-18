package BalancedBinaryTree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		return level(root) >= 0;
	}

	public int level(TreeNode root) {
		if ( root == null ) return 0;
		int currLeft = level(  root.left);
		int currRight = level(  root.right );
		if (currLeft < 0 || currRight < 0 || Math.abs(currLeft - currRight) > 1) 
			return -1;
		return Math.max(currLeft, currRight) + 1;
	}
}