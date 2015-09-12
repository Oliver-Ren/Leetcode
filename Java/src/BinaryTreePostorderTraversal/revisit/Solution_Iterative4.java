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

public class Solution_Iterative4 {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer> ();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        TreeNode prev = new TreeNode(-1);

        if (curr != null) {
            nodeStack.push(curr);
        }

        while (!nodeStack.isEmpty()) {
            curr = nodeStack.peek();
            if (curr.left != null && curr.left != prev && curr.right != prev) {
                nodeStack.push(curr.left);
            } else if (curr.right != null && curr.right != prev) {
                nodeStack.push(curr.right);
            } else {
                result.add(curr.val);
                nodeStack.pop();
            }
            prev = curr;

            
        }

        return result;
    }
}

