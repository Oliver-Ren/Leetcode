package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;



public class Solution_Recursive {
	
	    public static List<Integer> helper( List<Integer> L, TreeNode root ){
	        if (root != null){
	            helper( L, root.left );
	            L.add(root.val);
	            helper( L, root.right );
	        }
	        return L;
	       
	    }
	    
	    public static List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> L = new ArrayList<Integer>();
			helper(L, root);
			return L;
	    }
	    
	    public static void main(String args[]){
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			List<Integer> L = inorderTraversal(root);
			System.out.print(L);
		}
}

