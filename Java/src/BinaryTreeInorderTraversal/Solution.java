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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack();
        List<Integer> result = new LinkedList<Integer>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty() && nodeStack.peek() != null) {
            TreeNode curr = nodeStack.pop();

            if (curr.right != null) {
                nodeStack.push(curr.right);
            }

            if (curr.left == null) {
                result.add(curr.val);
                continue;
            }


            TreeNode left = curr.left;
            curr.left = null;
            curr.right = null;
            nodeStack.push(curr);

            if (left != null) {
                nodeStack.push(left);
            }
        }
        
        return result;

    }
}

