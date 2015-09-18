package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.ArrayList;

/**
 * This is the Recursive version of the Binary Tree PostorderTraversal
 * @author cr486
 *
 */
public class Solution_Recursive {
    private void traverse(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(result, root.left);
        traverse(result, root.right);
    }
	
	
	public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<Integer>();
        traverse(result, root);
        return result;
		
	}
}	
