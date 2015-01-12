package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.ArrayList;

/**
 * This is the Recursive version of the Binary Tree PostorderTraversal
 * @author cr486
 *
 */
public class Solution_Recursive {
	
	
	public static List<Integer> helper( List <Integer> L, TreeNode root){
		if (root == null) return L;
		else{
			L.add(root.val);
			helper(L, root.left);
			helper(L, root.right);	
		}
		return L;
	}
	
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> L = new ArrayList<Integer>();
		helper(L, root);
		return L;
		
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		List<Integer> L = preorderTraversal(root);
		System.out.print(L);
	}

}


