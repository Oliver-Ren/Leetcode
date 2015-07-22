/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* this is the iterative inorder traversal
 * solution.
 * the time complexity is O(logn + k)
 * the space complexity is O(logn)
 * Status: Accpeted.
 */

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode currNode = root;

        while (!nodeStack.empty() || currNode != null) {
            while (currNode != null) {
                nodeStack.push(currNode);
                currNode = currNode.left;
            } 
        
            currNode = nodeStack.pop();
            if (--k == 0) return currNode.val;
            currNode = currNode.right;
        }
        return 0;
    }
}

