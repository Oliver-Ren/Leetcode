/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is the iterative version. 
 * the time complexity is O(n).
 * the space complexity is O(logn).
 * Status: Accepted, 392ms.
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Deaing with invalid inputs.
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        int sum = 0;

