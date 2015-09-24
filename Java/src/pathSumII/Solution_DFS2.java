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
 * My second attempt using DFS and backtracking.
 * I will try to make the code more concise by making use of the propertyies
 * of recursive.
 * Time complexity: O(n) where n is the number of nodes.
 * Space complexity: O(logn) in average case, O(n) worst.
 * Status: accepted, 296ms.
 */

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(result, path, sum, root);
        return result;
    }

    // DFS method for recursively and backtrack;
    private void dfs(List<List<Integer>> result, List<Integer> path, int sum, TreeNode root) {
        // return if the node is empty
        if (root == null) {
            return;
        }

        // deduce the value in the root from sum.
        sum -= root.val;

        if (root.left == null & root.right == null & sum == 0) {
            path.add(root.val);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }

        // add current to path.
        path.add(root.val);
        dfs(result, path, sum, root.left);
        dfs(result, path, sum, root.right);
        // remove current to path.
        path.remove(path.size() - 1);
    }

}
