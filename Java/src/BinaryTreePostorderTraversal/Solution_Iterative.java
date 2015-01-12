package BinaryTreePostorderTraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution_Iterative {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> L = new ArrayList<Integer> ();
		TreeNode N = root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(N);
		while( !st.isEmpty()){
			N = st.pop();
			L.add(N.val);
			st.push(N.right);
			st.push(N.left);
		}
		return L;
	}

}
