
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* recursive calls.
 * Status: Accepted, 348ms.
 */ 

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return makeBST(1, n);
    }

    private List<TreeNode> makeBST(int left, int right) {
        List<TreeNode> cand = new LinkedList<TreeNode>();
        if (left > right) {
            cand.add(null);
            return cand;
        }

        

        for (int mid = left; mid <= right; mid++) {
            List<TreeNode> leftCand = makeBST(left, mid - 1);
            List<TreeNode> rightCand = makeBST(mid + 1, right);

            for (TreeNode l : leftCand) {
                for (TreeNode r : rightCand) {
                    TreeNode root = new TreeNode(mid);
                    root.left = l;
                    root.right = r;
                    cand.add(root);
                }
            }
        }

        return cand;
    }
}

