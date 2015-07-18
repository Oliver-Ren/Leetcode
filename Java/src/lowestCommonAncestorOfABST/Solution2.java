/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is a concise recursive solution
 * for the problem.
 * the time complexity is O(n), and the 
 * space complexity is O(logn).
 * Status: Accepted, 456ms. 
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null && p != null && p != null) {
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if  (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        } else {
            return null;
        }
    }
}
