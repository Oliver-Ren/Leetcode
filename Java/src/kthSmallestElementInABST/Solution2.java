
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* this is the recursive inorder traversal
 * solution.
 * the time complexity is O(logn + k)
 * the space complexity is O(logn)
 * Status: Accpeted.
 */

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int [] result = new int[2];
        dfs(root, k, result);
        return result[1];
    }

    private void dfs(TreeNode root, int k, int [] result) {
        if (root == null) {
            return;
        }

        dfs(root.left, k, result);
        result[0]++;
        if (result[0] != k) {
            dfs(root.right, k, result);
        } else {
            result[1] = root.val;
        }
        
    }
}





