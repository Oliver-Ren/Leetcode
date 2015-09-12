/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* this problem is solved by backtracking.
 * the time complexity is O(n).
 * the space complexity is O(logn).
 * Status: Accepted, 416ms.
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // dealing with invalid input where the root is 
        // null
        if (root == null) {
            return false;
        }

        // when this node is leaf, judge the sum.
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || 
            hasPathSum(root.right, sum - root.val);
    }
}

