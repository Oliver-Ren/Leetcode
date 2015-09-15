/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This is the iterative version. 
 * which usesd the BFS stragety.
 * the time complexity is O(n).
 * the space complexity is O(n).
 * Status: Accepted, 340ms.
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Deaing with invalid inputs.
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        
        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQueue.poll();
                int currSum = sumQueue.poll();

                if (currNode.left == null && currNode.right == null
                        && currSum == sum) {
                    return true;
                }

                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                    sumQueue.offer(currSum + currNode.left.val);
                }

                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                    sumQueue.offer(currSum + currNode.right.val);
                }

            }
        }

        return false;
    }
}



