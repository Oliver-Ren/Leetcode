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
        Queue<TreeNode> levelQueue2 = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root != null) {
            levelQueue.offer(root);
        }
        
        while (!levelQueue.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();
            while (!levelQueue.isEmpty()) {
                TreeNode currNode = levelQueue.poll();
                if (currNode.left != null) {
                    levelQueue2.offer(currNode.left);
                }
                if (currNode.right != null) {
                    levelQueue2.offer(currNode.right);
                }

                level.add(currNode.val);
            }
            
            result.add(level);
            Queue<TreeNode> temp = levelQueue;
            levelQueue = levelQueue2;
            levelQueue2 = temp;

        }

        return result;
    }
}
