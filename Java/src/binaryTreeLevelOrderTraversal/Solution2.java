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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root != null) {
            levelQueue.offer(root);
        }

        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = levelQueue.poll();
                level.add(currNode.val);
                
                if (currNode.left != null) {
                    levelQueue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    levelQueue.offer(currNode.right);
                }

            }

            result.add(level);
        }

        return result;
    }
}


