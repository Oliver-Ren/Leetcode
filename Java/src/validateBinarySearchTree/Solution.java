package ValidateBinarySearchTree;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode descendent, long min, long max) {
        if (descendent == null) return true;
        //if (! root instanceof TreeNode) return false;
        if (descendent.val <= min || descendent.val >= max ) return false;
        return helper(descendent.left, min, descendent.val) && helper(descendent.right, descendent.val, max);
    }
}