package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;



public class Solution_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        nodeStack.push(root);


        while (root != null) {
            if (root.left != null) {
                nodeStack.push(root.left);
                root.left = null;
            } else {
                result.add(root.val);
                nodeStack.pop();
                if (root.right != null) {
                    nodeStack.push(root.right);
                }
            }

            root = nodeStack.isEmpty() ? null : nodeStack.peek();
        }

        return result;
    }
}
