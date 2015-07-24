/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is the recursive solution for 
 * binary tree level order traversal.
 * Time complexity O(n);
 * Space complexity O(n) for output.
 * Status: Accepted, 356ms. 
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        traverse(root, result, 1);
        return result;
    }

    private void traverse(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() < level) {
            result.add(new LinkedList<Integer>());
        }

        result.get(level - 1).add(root.val);

        traverse(root.left, result, level + 1);
        traverse(root.right, result, level + 1);
    }
}
        
