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

        
        TreeNode curr = root; 

        while (curr != null) {


            if (curr.left == null) {
                result.add(curr.val);
               
            } else {
                TreeNode left = curr.left;
                curr.left = null;
                nodeStack.push(curr);
                curr = left;
                continue;
            }

            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
            
             curr = nodeStack.empty() ? null : nodeStack.pop();
        }
        
        return result;

    }

}


