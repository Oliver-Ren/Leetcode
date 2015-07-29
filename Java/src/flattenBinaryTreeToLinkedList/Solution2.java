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
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted, 344ms.
 */

public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (root != null) {
            nodeStack.push(root);
        }

        while (!nodeStack.empty()) {
            TreeNode curr = nodeStack.pop();
            
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }

            if (curr.left != null) {
                nodeStack.push(curr.left);
            }

            /* Important */
            curr.left = null;

            curr.right = nodeStack.empty() ? null : nodeStack.peek();
        }


    }
}

