
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is a one dimension DP solution
 * Status: Accepted, 308ms. 
 */

public class Solution_DP {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        dp[0].add(null);


        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            for (int lenLeft = 0; lenLeft < len; lenLeft++) {
                for (TreeNode left : dp[lenLeft]) {
                    for (TreeNode right : dp[len - lenLeft - 1]) { 
                        TreeNode root = new TreeNode(lenLeft + 1);
                        root.left = left;
                        root.right = clone(right, lenLeft + 1);
                        dp[len].add(root);
                    }
                }
            }
        }

        return dp[n];
    }


    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) {
            return root;
        }

        TreeNode newRoot = new TreeNode(root.val + offset);  
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}

