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
        if (root != null && root.left == null && root.right == null) {
            return root.val - sum == 0;
        } else if (root == null) {
            return false;
        }

        return hasPathSum(root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val); 



    }
}
