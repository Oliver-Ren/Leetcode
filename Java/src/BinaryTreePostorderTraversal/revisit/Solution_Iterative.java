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

        if (curr == null) {
            return result;
        }

        nodeStack.push(curr);

        while (!nodeStack.isEmpty()) {
            curr = nodeStack.pop();

            if (curr.left != null) {
                nodeStack.push(curr);
                nodeStack.push(curr.left);
                curr.left = null;
            } else if (curr.right != null) {
                nodeStack.push(curr);
                nodeStack.push(curr.right);
                curr.right = null;
            } else {
                result.add(curr.val);
            }
        }

        return result;

    }
}




