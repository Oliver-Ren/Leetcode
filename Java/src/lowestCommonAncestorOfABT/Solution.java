import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * My first attempt using DFS.
 * Time complexity: O(n) where n is the number of nodes.
 * Space complexity: O(logn).
 * Status: accetped;
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // precodition: p and q are in the tree and the tree is not null
        if (root == null || p == null || q == null) {
            return null;
        }
        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        result.add(new ArrayList<TreeNode>());
        result.add(new ArrayList<TreeNode>());
        List<TreeNode> path = new ArrayList<TreeNode>();
        path.add(root);
        dfs(result, path, p, q);
        return lastCommon(result.get(0), result.get(1));
    }
    
    private void dfs(List<List<TreeNode>> result, List<TreeNode>path, TreeNode p, TreeNode q) {
        TreeNode curr = path.get(path.size() - 1);
        if (curr == null) {
            return;
        }
        if (curr == p) {
            result.set(0, new ArrayList<TreeNode>(path));
            if (!result.get(1).isEmpty()) {
                return;
            }
        }
        
        if (curr == q) {
            System.out.print("hahah");
            result.set(1, new ArrayList<TreeNode>(path));
             if (!result.get(0).isEmpty()) {
                return;
            }
        }
        
        path.add(curr.left);
        dfs(result, path, p, q);
        path.remove(path.size() - 1);
        
        path.add(curr.right);
        dfs(result, path, p, q);
        path.remove(path.size() - 1);
        
    }
    
    private TreeNode lastCommon(List<TreeNode> l1, List<TreeNode>l2) {
        int i = 0;
        TreeNode parent = null;
        int minSize = Math.min(l1.size(), l2.size());
        for (TreeNode n : l2) {
            System.out.print("->" + n.val);
        }
        
        while (i < minSize && l1.get(i) == l2.get(i)) {
            parent = l1.get(i);
            System.out.print(parent.val);
            i++;
        }
        return parent;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        test.lowestCommonAncestor(root, left, root);
    }
}
