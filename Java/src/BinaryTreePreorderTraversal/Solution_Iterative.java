package BinaryTreePreorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution_Iterative {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> L = new ArrayList<Integer> ();
		TreeNode N = root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		if (N != null){
			st.push(N);
			while( !st.isEmpty() ){
				N = st.pop();
				L.add(N.val);
				if ( N.right != null ) st.push(N.right);
				if ( N.left != null ) st.push(N.left);
			}
		}
		return L;
	}

}
