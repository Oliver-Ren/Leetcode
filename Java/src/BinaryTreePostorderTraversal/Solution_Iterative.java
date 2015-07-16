package BinaryTreePostorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/** The iterative version of the postroder traversal.
  * The the structure of the tree will be changed 
  * during the traversal.
  * The time complexity is O(n), the space complexity
  * is O(n). 
  * Status: Accepted.
  */

public class Solution_Iterative {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer> ();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {
                TreeNode left = curr.left;
                curr.left = null;
                nodeStack.push(curr);
                curr = left;
            } else if (curr.right != null) {
                TreeNode right = curr.right;
                curr.right = null;
                nodeStack.push(curr);
                curr = right;
            } else {
                result.add(curr.val);
                curr = nodeStack.empty() ? null : nodeStack.pop();
            }
        }

        return result;
    }
}
