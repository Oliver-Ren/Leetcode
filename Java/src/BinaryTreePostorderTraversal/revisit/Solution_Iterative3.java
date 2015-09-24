package BinaryTreePostorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/** The iterative version of the postroder traversal.
  * This solutio does not change the structure of the tree.
  * The time complexity is O(n), the space complexity
  * is O(n). 
  * Status: Accepted.
  */

public class Solution_Iterative3 {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer> ();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        TreeNode prev = new TreeNode(-1);

        while (curr != null) {
            if (curr.left != null && prev != curr.left && prev != curr.right) {
                nodeStack.push(curr);
                prev = curr;
                curr = curr.left;
            } else if (curr.right != null && prev != curr.right) {
                nodeStack.push(curr);
                prev = curr;
                curr = curr.right;
            } else {
                result.add(curr.val);
                prev = curr;
                curr = nodeStack.isEmpty() ? null : nodeStack.pop();
            }
        }

        return result;
    }
}

