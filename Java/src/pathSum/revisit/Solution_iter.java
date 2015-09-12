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
        Stack<Integer> sumStack = new Stack<Integer>();

        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int currSum = sumStack.pop();

            if (curr.left == null && curr.right == null
                    && currSum == sum) {
                return true;
            }

            if (curr.right != null) {
                nodeStack.push(curr.right);
                sumStack.push(currSum + curr.right.val);
            }

            if (curr.left != null) {
                nodeStack.push(curr.left);
                sumStack.push(currSum + curr.left.val);
            }

        }

        return false;
    }
}


