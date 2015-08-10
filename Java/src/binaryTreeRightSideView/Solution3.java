
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* The dfs solution.
 * time complexity: O(n)
 * space complexity: O(logn), where n 
 * is the total number of nodes.
 * status: Accepted, 296ms.
 */

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<Integer>();
        dfs(root, rightView, 0);
        return rightView;
    }

    private void dfs(TreeNode root, List<Integer> rightView, int depth) {
        
        if (root == null) {
            return;
        }
        
        if (depth >= rightView.size()) {
            rightView.add(root.val);
        }
        dfs(root.right, rightView, depth + 1);
        dfs(root.left, rightView, depth + 1);
    }
}

        
