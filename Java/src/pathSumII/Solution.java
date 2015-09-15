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
 * My first attempt using DFS and backtracking.
 * Time complexity: O(n) where n is the number of nodes.
 * Space complexity: O(logn) in average case, O(n) worst.
 * Status: accepted, 348ms.
 */

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Dealing with corner cases.
        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        dfs(result, path, sum, root);
        return result;
    }

    // DFS method for recursively and backtrack;
    private void dfs(List<List<Integer>> result, List<Integer> path, int sum, TreeNode root) {
        // deduce the value in the root from sum.
        sum -= root.val;

        if (root.left == null & root.right == null & sum == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            dfs(result, path, sum, root.left); 
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            dfs(result, path, sum, root.right); 
            path.remove(path.size() - 1);
        }

    }

}
