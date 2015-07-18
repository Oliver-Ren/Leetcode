
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is the basic solution for the problem.
 * the algorithm first find a path from root to 
 * the two target nodes seperately, and then
 * find the furthest comman node in the two 
 * pathes.
 * the time complexity is O(n), and the space complexity
 * is also O(n).
 * Status: Accepted, 452ms.
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p == null) {
            return q;
        } else if (q == null) {
            return p;
        }

        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        findPath(path1, root, p);
        findPath(path2, root, q);
        return findCommon(path1, path2); 
         
    }


    private void findPath(List<TreeNode> path, TreeNode root, TreeNode target) {
        if (target.val == root.val) {
            path.add(target);
            return;
        } else if (target.val > root.val) {
            path.add(root);
            findPath(path, root.right, target);
        } else {
            path.add(root);
            findPath(path, root.left, target);
        }
    }

    private TreeNode findCommon(List<TreeNode> path1, List<TreeNode> path2) {
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) == path2.get(i)) {
                i++;
            } else {
                break;
            }
        }

        return path1.get(i - 1);
    }
}


