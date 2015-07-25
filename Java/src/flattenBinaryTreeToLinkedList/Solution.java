/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted, 368ms.
 */

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        
        TreeNode connector = root.left;
        if (connector == null) {
            return;
        }

        while (connector.right != null) {
            connector = connector.right;
        }

        connector.right = root.right;
        root.right = root.left;
        root.left = null;        
    }



}
