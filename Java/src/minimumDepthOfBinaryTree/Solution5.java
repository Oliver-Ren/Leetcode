
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* The second iteratove version. 
 * Using the BFS level order traversal.
 * Time O(n);
 * space O(logn);
 * Status: Accepted, 340ms.
 */

public class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        boolean isFound = false;
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty() && !isFound) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (curr.left == null & curr.right == null) {
                    isFound = true;
                    break;
                }
            }
        }

        return depth;
    }
}

