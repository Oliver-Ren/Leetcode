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
    public int sumNumbers(TreeNode root) {
       int result = 0;
	   return helper(root, 0);

    }

	private int helper(TreeNode root, int sum) {
		if (root == null) {
			return sum;
		}

		sum = sum * 10 + root.val;

		if (root.left == null) {
			return helper(root.right, sum);
		} else if (root.right == null) {
			return helper(root.left, sum);
		} else {
			return helper(root.right, sum) + helper(root.left, sum);
		}
	}
}
