package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;



public class Solution_Recursive {
	
	    
	    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            traverse(result, root);
            return result;
	    }

        private void traverse(List<Integer> result, TreeNode root) {
            if (root == null) {
                return;
            }

            traverse(result,root.left);
            result.add(root.val);
            traverse(result, root.right);
        }
}
	    
