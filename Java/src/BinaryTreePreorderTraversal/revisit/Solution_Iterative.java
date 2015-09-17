package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution_Iterative {
	public static List<Integer> reorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            result.add(curr.val);
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }

            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
        }

        return result;
    }
}


