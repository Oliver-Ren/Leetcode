package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;

/**
 * The iterative solution
 * which will change the 
 * structure of the original
 * tree.
 */

public class Solution_Iterative2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }

            if (curr.left != null) {
                nodeStack.push(curr);
                nodeStack.push(curr.left);
                curr.left = null;
            } else {
                result.add(curr.val);
            }
            
            curr = nodeStack.isEmpty() ? null : nodeStack.pop();
        }

        return result;
    }
}
