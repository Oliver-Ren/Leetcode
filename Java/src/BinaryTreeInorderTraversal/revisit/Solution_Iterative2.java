package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;



public class Solution_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        
        if (root == null) {
            return result;
        }

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.peek();
            if (curr.left != null) {
                nodeStack.push(curr.left);
                curr.left = null;
            } else {
                result.add(curr.val);
                nodeStack.pop();
                if (curr.right != null) {
                    nodeStack.push(curr.right);
                }
            }

        }

        return result;
    }
}
            

