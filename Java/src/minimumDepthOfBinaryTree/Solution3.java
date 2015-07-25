
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* a simpler recursive version. 
 * Time O(n);
 * space O(logn);
 */

public class Solution {
    public int minDepth(TreeNode root) {
        return findMinDepth(root, false);
    }

    private int findMinDepth(TreeNode root, boolean hasBrother) {
        if (root == null) {
            return hasBrother ? Integer.MAX_VALUE : 0;
        }

        return Math.min(findMinDepth(root.left, root.right != null)
                , findMinDepth(root.right, root.left != null)) + 1;
    }
}
