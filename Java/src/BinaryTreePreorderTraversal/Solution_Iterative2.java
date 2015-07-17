
package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution_Iterative2 {
	public static List<Integer> reorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        nodeStack.push(root);
    
        while (!nodeStack.empty()) {
            TreeNode curr = nodeStack.pop();
            if (curr == null) continue;
            result.add(curr.val);
            nodeStack.push(curr.right);
            nodeStack.push(curr.left);
        }

        return result;
    }
}


