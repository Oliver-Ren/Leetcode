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
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> valueStack = new Stack<Integer>();
        int currSum = 0;

        if (root == null) {
            return false;
        }

        nodeStack.push(root);
        valueStack.push(root.val);
        
        while (!nodeStack.empty()) {
            TreeNode currNode = nodeStack.pop();
            currSum = valueStack.pop();

            if (currSum == sum && currNode.left == null
                    && currNode.right == null) {
                return true;
            }

            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                valueStack.push(currSum + currNode.right.val);
            }

            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                valueStack.push(currSum + currNode.left.val);
            }
        }

        return false;
    }
}


