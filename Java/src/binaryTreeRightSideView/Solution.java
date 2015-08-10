
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* the level order traversal solution.
 * time complexity: O(n), where n is the total 
 * number of nodes.
 * space complexity: O(n) in the worst case where the 
 * tree is a complete binary tree.
 * Status: Accpted, 376ms.
 */

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<Integer>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        if (root != null) {
            nodeQueue.offer(root);
        }

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = nodeQueue.poll();
                if (current.left != null) {
                    nodeQueue.offer(current.left);
                }

                if (current.right != null) {
                    nodeQueue.offer(current.right);
                }

                if (i == size - 1) {
                    rightView.add(current.val);
                }

            }
        }

        return rightView;
    }
}
