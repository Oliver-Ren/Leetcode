
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            makeBST(root);
            
        }
        
    }

    private void makeBST(TreeNode root, int left, int mid, int right, boolean isLeft) {
        if (mid <= left && isLeft) {
            makeBST(root, false);
        }


        if (!isLeft) {
            makeBST(
        } else {


        for (int mid = left; mid <= right; mid++) {
            TreeNode newRoot = new TreeNode(mid);
            root.left = newRoot;
            if (mid > left) {
                makeBST(newRoot, left, mid - 1, true);
            } else {
                makeBST(root, mid + 1, right, false);
        }



}
