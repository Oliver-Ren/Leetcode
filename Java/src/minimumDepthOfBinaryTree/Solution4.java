/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* The first iterative version. 
 * it is based on the post-order traversal.
 * and the depth >= minDepth will be trimmed.
 * Time O(n);
 * space O(logn);
 * Accpeted: 352ms.
 */

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        TreeNode curr = root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode prev = root;
        int minDepth = Integer.MAX_VALUE;
        int currDepth = 1;
        
        while (curr != null) {
            if (currDepth < minDepth && curr.left != null && prev != curr.left && prev != curr.right) {
                nodeStack.push(curr);
                prev = curr;
                curr = curr.left;
                currDepth++;
            } else if (currDepth < minDepth && curr.right != null && prev != curr.right) {
                nodeStack.push(curr);
                prev = curr;
                curr = curr.right;
                currDepth++;
            } else {
                if (curr.left == null && curr.right == null) {
                    minDepth = Math.min(minDepth, currDepth);
                }
                currDepth--;
                prev = curr;
                curr = nodeStack.empty() ? null : nodeStack.pop();
            }
        }

        return minDepth;
    }
}
