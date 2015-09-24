package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;

<<<<<<< HEAD
/**
 * The iterative solution
 * which will change the 
 * structure of the original
 * tree.
 */

public class Solution_Iterative2 {
=======


public class Solution_Recursive {
>>>>>>> 09678b20876f1b15207159ec83fc5f8ae02eabcb
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

<<<<<<< HEAD
        TreeNode curr = root;
       
        
=======
        
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
            

>>>>>>> 09678b20876f1b15207159ec83fc5f8ae02eabcb
