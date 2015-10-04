package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution_Iterative {
	public static List<Integer> reorderTraversal(TreeNode root){
        List<Integer> result = new Arraylist<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode curr = root;

        while (curr != null) {
            result.add(curr.val);
            if (curr.right != null) {
               nodeStack.push(curr.right);
            }

            if (curr.left != null) {
                nodeStack.push(curr.left);
            }

            curr = nodeStack.isEmpty() ? null : nodeStack.pop();
        }
    }
}
